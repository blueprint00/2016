
module decoder(a, d0, d1, d2, d3);

	input [1:0]a;
	output d0, d1, d2, d3;	

	wire [1:0]a;
	reg d0, d1, d2, d3;

	always @(a) begin
		case(a) 
			2'b00 : begin
				d0 = 1;
				d1 = 0;
				d2 = 0;
				d3 = 0;
			end
			2'b01 : begin
				d0 = 0;
				d1 = 1;
				d2 = 0;
				d3 = 0;
			end
			2'b10 : begin
				d0 = 0;
				d1 = 0;
				d2 = 1;
				d3 = 0;
			end
			2'b11 : begin
				d0 = 0;
				d1 = 0;
				d2 = 0;
				d3 = 1;
			end
	
		endcase
	end

endmodule