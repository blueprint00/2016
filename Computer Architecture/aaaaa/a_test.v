
module DIGIT_COM_test;
reg [7:0] A;
wire [2:0] Y;
wire VALID;
pencode ucc(.A(A), .Y(Y), .Valid(Valid));
initial 
begin
 A<=0;
 #200 A = 8'b11001110;
 #200 A = 8'b10100110;
 #200 A = 8'b00100110;
 #200 A = 8'b00001110;
 #200 A = 8'b00000000;
 #100 $stop;
end
endmodule 