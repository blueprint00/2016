
module pencode(A, Y, Valid);

	input [7:0]A;
	output [2:0] Y;
	output Valid;

	wire [7:0]A;
	reg [2:0]Y;
	reg Valid;
	
	always@(A) begin
		if(A == 8'b00000000) begin
			Valid = 1'b0;
		end
		else if(A == 8'b00000001) begin
			Valid = 1'b1;
			Y = 3'b000;
		end
		else if(A[7:1] == 7'b0000001) begin
			Valid = 1'b1;
			Y = 3'b001;
		end 
		else if(A[7:2] == 6'b000001) begin
			Valid = 1'b1;
			Y = 3'b010;	
		end
		else if(A[7:3] == 5'b00001) begin
			Valid = 1'b1;
			Y = 3'b011;
		end
		else if(A[7:4] == 4'b0001) begin
			Valid = 1'b1;
			Y = 3'b100;
		end
		else if(A[7:5] == 3'b001) begin
			Valid = 1'b1;
			Y = 3'b101;
		end
		else if(A[7:6] == 2'b01) begin
			Valid = 1'b1;
			Y = 3'b110;
		end
		else if(A[7] == 1'b1) begin
			Valid = 1'b1;
			Y = 3'b111;
		end
	end
endmodule