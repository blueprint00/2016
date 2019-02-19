	/*`define s0 2'b00
	`define s1 2'b01
	`define s2 2'b10
	`define s3 2'b11*/

module seq_detector(CLK, RESETn, x, z);
	input CLK, RESETn, x;
	output z;

	wire CLK, RESETn, x;
	reg z;
	reg [1:0]state;

	parameter [1:0] s0 = 2'b00, s1 = 2'b01, s2 = 2'b10, s3 = 2'b11;

	always@(posedge CLK or negedge RESETn) begin
		if(~RESETn) begin
			state <= s0;
		end
		else begin
			case(state) 
				s0 : begin
					state <= x? s1 : s0;
				end
				s1 : begin
					state <= x? s1 : s2;
				end
				s2 : begin
					state <= x? s1 : s3;
				end
				s3 : begin
					state <= x? s1 : s0;
				end
				default : $stop;
			endcase
		end
	end

	always@(state) begin
		case(state)
			s0, s1, s2 : z = 0;
			s3 : z = 1;		
		endcase
	end
endmodule