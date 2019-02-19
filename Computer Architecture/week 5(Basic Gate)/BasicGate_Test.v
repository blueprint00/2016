`timescale 1ns/1ns

module basic_gate_test;

	reg in1, in2;
	wire outand, outor, outnot, outnand, outnor, outxor, outxnor;
	
	basic_gate ucc(.in1(in1), .in2(in2),
			 .outand(outand), .outor(outor), .outnot(outnot), 
			 .outnand(outnand), .outnor(outnor), 
			 .outxor(outxor), .outxnor(outxnor));
			 
	initial begin
		in1 = 1'b0; in2 = 1'b0;
		#10 in1 = 1'b0; in2 = 1'b1;
		#10 in1 = 1'b1; in2 = 1'b0;
		#10 in1 = 1'b1; in2 = 1'b1;
		#10 $stop;
	end

endmodule
