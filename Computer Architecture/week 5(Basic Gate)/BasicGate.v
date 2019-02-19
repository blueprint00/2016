`timescale 1ns/1ns

module basic_gate(in1, in2, outand, outor, outnot, outnand, outnor, outxor, outxnor);
	
	input in1, in2;
	output outand, outor, outnot, outnand, outnor, outxor, outxnor;

	wire in1, in2;
	wire outand, outor, outnot, outnand, outnor, outxor, outxnor;

	assign outand = in1 & in2;
	assign outor = in1 | in2;
	assign outnot = ~in1;
	assign outnand = ~(in1 & in2);
	assign outnor = ~(in1 | in2);
	assign outxor = in1 ^ in2;
	assign outxnor = ~(in1 ^ in2); 


endmodule