
`timescale 1ns/1ns

module Basic_Gate_Test;
	reg input1, input2;
	wire And_out, Or_out, Not_out, Nand_out, Nor_out, Xor_out, Xnor_out;
	
	Basic_Gate Basic_Gate_Unit(.in1(input1), .in2(input2),
			 .and_out(And_out), .or_out(Or_out), .not_out(Not_out), 
			 .nand_out(Nand_out), .nor_out(Nor_out), 
			 .xor_out(Xor_out), .xnor_out(Xnor_out));
			 
	initial begin
		#10 input1 = 0; input2 = 0;
		#10 input1 = 0; input2 = 1;
		#10 input1 = 1; input2 = 0;
		#10 input1 = 1; input2 = 1;
		#10 $stop;
	end
endmodule