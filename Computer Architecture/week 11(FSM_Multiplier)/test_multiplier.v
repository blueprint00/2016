module test_multiplier4x4();

reg RESETn, CLK;
reg process_start;
reg [3:0] multiplier, multiplicand;

wire [7:0] product;
wire process_done;

multiplier4x4 MUL4x4(RESETn, CLK, process_start, multiplier, multiplicand, product, process_done);

always #10 CLK = ~CLK;

initial
begin
  RESETn = 1'b0; CLK = 1'b1; multiplier = 4'h0; multiplicand = 4'h0; process_start = 1'b0;
  #30 RESETn = 1'b1;
  #20 multiplier = 4'h4; multiplicand = 4'h9; process_start = 1'b1;
  #20 process_start = 1'b0;
  #1000 $stop;
end

endmodule
