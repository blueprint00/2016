`timescale 1ns/1ns
module VM_TEST;
	
	reg In;			// 0 = 50, 1 = 100
	reg Select;		// if 1, work
	reg CLK, nRESET;
	wire Out;		// result
	wire [3:0]Change;	// change

	VM uVM(.In(In), .Select(Select),
		.Out(Out), .Change(Change),
		.CLK(CLK), .nRESET(nRESET));
	
	always #10 CLK = ~CLK;
	
	initial begin
		CLK = 1'b1; nRESET = 1'b0;
		
		#15 nRESET = 1'b1; In = 1'b0;
		
		/* under 200
		#20 In = 1'b1; Select = 1;
		*/

		/* under 200
		#20 In = 1'b0; Select = 1;
		*/
	
		/* 200
		#20 In = 1'b0; Select = 0;
		#20 In = 1'b1; Select = 0;
		#20 In = 1'b0; Select = 1;
		*/

		/* over 200 under 400
		#20 In = 1'b0; Select = 0;
		#20 In = 1'b1; Select = 0;
		#20 In = 1'b1; Select = 1;
		*/

		//* over 400
		#20 In = 1'b0; Select = 1;
		#20 In = 1'b1; Select = 0;
		#20 In = 1'b1; Select = 0;
		#20 In = 1'b1; Select = 1;
		//*/
		
		#20 $stop;
	end

endmodule
