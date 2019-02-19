`timescale 1ns/1ns

module VM(In, Select, Change, Out, CLK, nRESET);
   input In, Select, CLK, nRESET;
   output Change;
   output Out;

   wire In, Select, CLK, nRESET;
   reg Change;
   reg Out;

   parameter A = 4'b0000,B = 4'b0001,C = 4'b0010,
	      D = 4'b0011,E = 4'b0100,F = 4'b0101,
	      G = 4'b0110,H = 4'b0111,I = 4'b1000;

   reg [3:0] MealyState, NextState;
   
//sequential logic-state register
   always @(posedge CLK or negedge nRESET) begin
      if(~nRESET)
         MealyState <= A;
      else
         MealyState <= NextState;
   end

// combinational logic-NextState logic
   always @(MealyState or In) begin
      case(MealyState)
         A : begin
            NextState = In ? C : B;
            if(Select) begin
               Out = 1'b0;
               Change = 1'b1;
            end
         end
         B : begin
            NextState = In ? D : C;
            if(Select) begin
               Out = 1'b0;
               Change = 1'b1;
            end
         end
         C : begin
            NextState = In ? E : D;
            if(Select) begin
               Out = 1'b0;
               Change = 1'b1;
            end         
         end
         D : begin
            NextState = In ? F : E;
            if(Select) begin
               Out = 1'b0;
               Change = 1'b1;
            end         
         end
         E : begin
            NextState = In ? G : F;
            if(Select) begin 
               Out = 1'b1;
               Change = 1'b1;
            end
         end
         F : begin
            NextState = In ? H : G;
            if(Select) begin 
               Out = 1'b1;
               Change = 1'b1;
            end
         end
         G : begin
            NextState = In ? I : H;
            if(Select) begin 
               Out = 1'b1;
               Change = 1'b1;
            end
         end
         H : begin
            NextState = In ? I : I;
            if(Select) begin 
               Out = 1'b1;
               Change = 1'b1;
            end
         end
         I : begin
            NextState = In ? I : I;
            if(Select) begin 
               Out = 1'b1;
               Change = 1'b1;
            end
         end
      endcase
   end
endmodule