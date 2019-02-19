`define IDLE  2'b00
`define ADD   2'b01
`define SHIFT 2'b10
`define CHECK 2'b11

module multiplier4x4(RESETn, CLK, process_start, multiplier, multiplicand, product, process_done);

input RESETn, CLK;
input process_start;
input [3:0] multiplier, multiplicand;

output [7:0] product;
output process_done;

reg [7:0] product;
reg process_done;

reg [1:0] state;
reg [1:0] process_counter;

reg [3:0] reg_multiplier;
reg [7:0] reg_multiplicand;

//state_machine
always @(negedge RESETn or posedge CLK)
begin
  if(~RESETn)
    state <= `IDLE;
  else begin
    case(state)
      `IDLE:  begin  
                if(process_start) 
                  state <= `ADD;
                else
                  state <= `IDLE;
              end
      `ADD:   begin 
		state <= `SHIFT;
              end
      `SHIFT: begin 
		state <= `CHECK;
              end
      `CHECK: begin
                if(process_counter == 2'b11)
                  state <= `IDLE;
                else
                  state <= `ADD;
              end
    endcase
  end
end

//loop counter 
always @(negedge RESETn or posedge CLK)
begin
  if(~RESETn)
    process_counter <= 2'b11;
  else begin
    case (state)
      `SHIFT: process_counter <= process_counter + 2'b01;
      default: process_counter <= process_counter;
    endcase
  end
end

//shift register
always @(negedge RESETn or posedge CLK)
begin
  if(~RESETn) begin
    reg_multiplier <= 0;
    reg_multiplicand <= 0;
  end
  else begin
    case (state)
      `IDLE: begin  
          if(process_start) begin
            reg_multiplier <= multiplier;
    	    reg_multiplicand <= {4'h0, multiplicand};
          end
          else begin
            reg_multiplier <= 0;
    	    reg_multiplicand <= 0;
          end
        end
      `SHIFT: begin
	 reg_multiplier = reg_multiplier >> 1; 
         reg_multiplicand = reg_multiplicand << 1;
      	       end
       default: begin
                 reg_multiplier <= multiplier;
    		 reg_multiplicand <= multiplicand; //?? ? ??
                end
    endcase
  end
end

//output case
always @ ( * )
begin
  case (state)
    `IDLE: begin
             product = 4'h0;
             process_done = 1'b0;
           end
    `ADD: begin
            if(reg_multiplier[0]) begin
              product = product + reg_multiplicand;
            end
            else begin
              product = product;
	      process_done = 1'b0;
            end
          end
    `SHIFT: begin
    	       product = product;
	       process_done = 1'b0;
            end
    `CHECK: begin
    	       if(process_counter == 2'b11) begin
               	  product = product;
	       	  process_done = 1'b1;
               end
               else begin
               product = product;
	           process_done = 1'b0;
               end
            end
  endcase
end

endmodule
