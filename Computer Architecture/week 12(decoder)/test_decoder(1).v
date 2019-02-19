
module test_decoder();

reg [1:0] a;

wire d0, d1, d2, d3;

decoder u0(a, d0, d1, d2, d3);

initial 
begin 
	a<=0;
	#40 a = 2'b00;
	#40 a = 2'b01;
	#40 a = 2'b10;
	#40 a = 2'b11;
	#40 a = 2'b00;
	#40 a = 2'b01;
	#40 a = 2'b10;
	#40 a = 2'b11;
	#40 a = 2'b00;
	#40 a = 2'b01;
	#40 a = 2'b10;
	#40 a = 2'b11;
	#40 a = 2'b00;
	#40 a = 2'b01;
	#40 a = 2'b10;
	#40 a = 2'b11;
	#40 a = 2'b00;
	#40 a = 2'b01;
	#40 a = 2'b10;
	#40 a = 2'b11;
	#10 $stop;
end
endmodule



