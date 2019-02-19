module fsm_test;
	reg x, CLK, RESETn;
	wire z;
	wire A,B;
  
  	fsm f1(RESETn, CLK, x, z, A, B);
  
  	always #50 CLK = ~CLK;
	initial
	begin
    		CLK=1; RESETn=0; x=0;
    		#5 RESETn=1'b1; 
   	 	#100 x=1'b1;
    		#100 x=1'b0;
    		#100 x=1'b1;
    		#100 x=1'b1;
    		#100 x=1'b0;
    		#300 $stop;
  	end
endmodule
