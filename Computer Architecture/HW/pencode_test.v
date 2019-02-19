
module pencode_test;
	reg [7:0]A;
	wire [2:0]Y;
	wire Valid;
	
	pencode ucc(.A(A), .Y(Y), .Valid(Valid));

	initial begin
		A = 8'h0;
		#10 A = 8'b00000001;

		#10 A = 8'b00000011;

		#10 A = 8'b00000100;
		#10 A = 8'b00000110;

		#10 A = 8'b00001000;
		#10 A = 8'b00001011;

		#10 A = 8'b00010011;
		#10 A = 8'b00010111;

		#10 A = 8'b00100110;
		#10 A = 8'b00101101;

		#10 A = 8'b01001010;
		#10 A = 8'b01010100;

		#10 A = 8'b10000000;
		#10 A = 8'b10001011;

		#10 $stop;
	end
endmodule