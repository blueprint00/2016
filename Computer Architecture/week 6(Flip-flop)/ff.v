`timescale 1ns/1ns;

module ff(clk, rst, in, en, out);

	input clk, rst, in, en;
	output out;

	wire clk, rst, in, en;
	reg out;

	always @(posedge clk) begin
		if(rst)
			out <= 1'b0;
		else if(en)
			out <= in;		

	end

endmodule

