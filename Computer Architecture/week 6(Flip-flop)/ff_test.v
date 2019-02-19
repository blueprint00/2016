`timescale 1ns/1ns

`timescale 1ns/1ns

module ff_test;

	reg clk, rst, in, en;
	wire out;

	ff utt(.clk(clk), 
		.rst(rst), 
		.in(in), 
		.en(en), 
		.out(out)
		);
	
	always #10 clk = ~clk;

	initial
	begin 
	clk = 1'b0; rst = 1'b1; in = 1'b0; en = 1'b0;
	#30 rst = 1'b0;
	#20 in = 1'b1; en = 1'b1;
	#20 in = 1'b0; en = 1'b0;
	#20 en = 1'b1; 
	#50 $stop;
	end
endmodule 