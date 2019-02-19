module combi_logic(rst, a, b, c, clk, result);

	input [3:0]a, b;
	input [7:0]c;
	input clk, rst;
	output [7:0]result;

	reg [3:0]reg_a, reg_b;
	reg [7:0]reg_c, reg_c2;
	reg [7:0]reg_product, result;

	always @(posedge clk or negedge rst) begin
		if(~rst) begin
			reg_a <= 4'h0;
			reg_b <= 4'h0;
			reg_c <= 8'h0;
			reg_c2 <= 8'h0;
			reg_product <= 8'h0;
			result <= 8'h0;
		end
		else begin
			reg_a <= a;
			reg_b <= b;
			reg_c <= c;

			reg_product <= reg_a * reg_b;
			reg_c2 <= reg_c;

			result <= reg_product + reg_c2;
		end
	end
	
endmodule