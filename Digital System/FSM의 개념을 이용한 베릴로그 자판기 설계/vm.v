`timescale 1ns/1ns
module vm( CLK,
             Coin,
             Select, 
             nRESET,
             Drink,
             Control,
             Change);

input CLK, nRESET;
input [1:0]Coin;
input Select;               
output Drink;
output Control;
output Change;

reg Drink;
reg Control;
reg Change;
reg [3:0] state;
reg [3:0] next_state;

parameter [1:0] Coin0 = 2'b00, Coin50 = 2'b01, Coin100 = 2'b10;
parameter [3:0] s0=4'h0, s1=4'h1, s2=4'h2, s3=4'h3, s4=4'h4, s5=4'h5, s6=4'h6, s7=4'h7, s8=4'h8;
 
always @(posedge CLK or negedge nRESET) begin
    if(nRESET == 0) next_state <= s0;
    else begin
      case(next_state)
        s0:if (Coin == 2'b01) begin state <= s1; Control = 0; end
          else if(Coin == 2'b10) begin state <= s2; Control = 0; end
          else begin state <= s0; Control = 0; end
            
        s1:if(Coin == 2'b01) begin state <= s2; Control = 0; end
          else if(Coin == 2'b10) begin state <= s3; Control = 0; end
          else begin state <= s1; Control = 0; end
           
        s2:if(Coin == 2'b01) begin state <= s3; Control = 0; end
          else if(Coin == 2'b10) begin state <= s4; Control = 0; end
          else begin state <= s2; Control = 0; end
            
        s3:if(Coin == 2'b01) begin state <= s4; Control = 0; end
          else if(Coin == 2'b10) begin state <= s5; Control = 0; end
          else begin state <= s3; Control = 0; end
                  
        s4:if(Coin == 2'b01) begin state <= s5; Control = 0; end
          else if(Coin == 2'b10) begin state <= s6; Control = 0; end
          else begin state <= s4; Control = 0; end
            
        s5:if(Coin == 2'b01) begin state <= s6; Control = 0; end
          else if(Coin == 2'b10) begin state <= s7; Control = 0; end
          else begin state <= s5; Control = 0; end
            
        s6:if(Coin == 2'b01) begin state <= s7; Control = 0; end
          else if(Coin == 2'b10) begin state <= s8; Control = 0; end
          else begin state <= s6; Control = 0; end
            
        s7:if(Coin == 2'b01) begin state <= s8; Control = 0; end
          else if(Coin == 2'b10) begin state <= s8; Control = 1; end
          else  begin state <= s7; Control = 0; end
            
        s8:if(Coin == 2'b01) begin state <= s8; Control = 1; end
          else if(Coin == 2'b10) begin state <= s8; Control = 1; end
          else  begin state <= s8; Control = 0; end  
        default : state <= s0;  
      endcase
    end
  end
  
always @(state or Select) begin
    if(Select == 1) begin
      Drink = 1'b0;
      case(state)
        s0: begin Drink = 1'b0; Change = 1'b0; next_state = s0; end
        s1: begin Drink = 1'b0; Change = 1'b1; next_state = s1; end
        s2: begin Drink = 1'b0; Change = 1'b1; next_state = s2; end
        s3: begin Drink = 1'b0; Change = 1'b1; next_state = s3; end
        s4: begin Drink = 1'b1; Change = 1'h0; next_state = s0; end
        s5: begin Drink = 1'b1; Change = 1'b1; next_state = s1; end
        s6: begin Drink = 1'b1; Change = 1'b1; next_state = s2; end
        s7: begin Drink = 1'b1; Change = 1'b1; next_state = s3; end
        s8: begin Drink = 1'b1; Change = 1'b1; next_state = s4; end
      endcase
    end
    else begin
      Drink = 1'b0;
      case(state)
        s0: begin Change = 1'b0; next_state = s0; end
        s1: begin Change = 1'b1; next_state = s1; end
        s2: begin Change = 1'b1; next_state = s2; end
        s3: begin Change = 1'b1; next_state = s3; end
        s4: begin Change = 1'b1; next_state = s4; end
        s5: begin Change = 1'b1; next_state = s5; end
        s6: begin Change = 1'b1; next_state = s6; end
        s7: begin Change = 1'b1; next_state = s7; end
        s8: begin Change = 1'b1; next_state = s8; end
      endcase
    end
  end
endmodule



