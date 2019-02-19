

//	E-Mail : yjjoo@rayman.sejong.ac.kr

module Basic_Gate (
		// Port lists
		in1, in2,
		and_out, or_out, not_out, nand_out, nor_out, xor_out, xnor_out);
		
		input in1, in2;
		output and_out, or_out, not_out, nand_out, nor_out, xor_out, xnor_out;
		
		wire in1, in2;
		wire and_out, or_out, not_out, nand_out, nor_out, xor_out, xnor_out;
		
		// AND Gate
		/*
			-----------
			in1	in2	out
			-----------
			 0	 0	 0
			 0	 1	 0
			 1	 0	 0
			 1	 1	 1
			-----------
		*/
		assign and_out = in1 & in2;
		
		// OR Gate
		/*
			-----------
			in1	in2	out
			-----------
			 0	 0	 0
			 0	 1	 1
			 1	 0	 1
			 1	 1	 1
			-----------
		*/
		assign or_out = in1 | in2;
		
		// NOT Gate
		/*
			-------
			in1	out
			-------
			 0	 1
			 1	 0
			-------
		*/
		assign not_out = ~in1;
		
		// NAND Gate
		/*
			-----------
			in1	in2	out
			-----------
			 0	 0	 1
			 0	 1	 1
			 1	 0	 1
			 1	 1	 0
			-----------
		*/
		assign nand_out = ~(in1 & in2);
		
		// NOR Gate
		/*
			-----------
			in1	in2	out
			-----------
			 0	 0	 1
			 0	 1	 0
			 1	 0	 0
			 1	 1	 0
			-----------
		*/
		assign nor_out = ~(in1 | in2);
		
		// XOR Gate
		/*
			-----------
			in1	in2	out
			-----------
			 0	 0	 0
			 0	 1	 1
			 1	 0	 1
			 1	 1	 0
			-----------
		*/
		assign xor_out = in1 ^ in2;
		
		// XNOR Gate
		/*
			-----------
			in1	in2	out
			-----------
			 0	 0	 1
			 0	 1	 0
			 1	 0	 0
			 1	 1	 1
			-----------
		*/
		assign xnor_out = ~(in1 ^ in2);
		
endmodule