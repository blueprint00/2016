module fsm(RESETn, CLK, x, z, A, B);

	input RESETn, CLK, x;
	output z, A, B;
	wire RESETn, CLK, x;
	reg z, A, B;

always@(posedge CLK or negedge RESETn)
	begin
		if(~RESETn) begin	//if(RESETn == 1'b0)
			A <= 1'b0;
			B <= 1'b0;	//{A,B} <= 2'b00;
			z <= 1'b0;
		end
		else begin
			case({A, B})
				2'b00 : begin
					z = 0;
					{A, B} = x ? 2'b11 : 2'b01;
				end
				2'b01 : begin
					z = 1;
					{A, B} = x ? 2'b10 : 2'b00;
				end
				2'b10 : begin
					z = 1;
					{A, B} = x ? 2'b01 : 2'b10;
				end
				2'b11 : begin
					z = 1;
					{A, B} = x ? 2'b10 : 2'b11;
				end
			endcase
				
		end
	end

endmodule
	