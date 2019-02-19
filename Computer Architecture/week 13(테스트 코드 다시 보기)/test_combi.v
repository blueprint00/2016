module test_combi;

	reg [3:0]a, b;
	reg[7:0]c;
	reg clk, rst;
	wire [7:0]result;

	combi_logic ucc(.rst(rst), .a(a), .b(b), .c(c), .clk(clk), .result(result));

	always #10 clk = ~clk;

	initial begin
		a = 4'h0; b = 4'h0; c = 8'h0; clk = 1; rst = 0;		

		#30 rst = 1;
		#20 a = 4'h3; b = 4'h3; c = 8'h7;
		#20 a = 4'h2; b = 4'h2; c = 8'h2;
		#20 a = 4'h4; b = 4'd10;
		#20 a = 4'h5; b = 4'h5; c = 8'd19;
		#20 a = 4'h1; b = 4'h1; c = 8'd11;
	end



endmodule