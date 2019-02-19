module pencode(A,Y,Valid);

input [7:0]A;
output [2:0]Y,Valid;

wire [7:0]A;
reg [2:0]Y,Valid;

always@(A)
begin//1
  if(A[7]==1'b1)
  begin//2
    Y=3'b111;
    Valid =1'b1;
  end//2
  else
  begin//2
    if(A[6]==1'b1)
    begin//3
      Y=3'b110;
      Valid =1'b1;
    end//3
    else
    begin//3
      if(A[5]==1'b1)
      begin//4
        Y=3'b101;
        Valid =1'b1;
      end//4
      else
      begin//4
          if(A[4]==1'b1)
          begin//5
            Y=3'b100;
            Valid=1'b1;
          end//5
          else
          begin//5
            if(A[3]==1'b1)
            begin//6
              Y=3'b011;
              Valid=1'b1;
            end//6
            else
            begin//6
              if(A[2]==1'b1)
              begin//7
                Y=3'b010;
                Valid=1'b1;
              end//7
              else
              begin//7
                if(A[1]==1'b1)
                begin//8
                  Y=3'b001;
                  Valid=1'b1;
                end//8
                else
                begin//8
                  if(A[0]==1'b1)
                  begin//9
                    Y=3'b000;
                    Valid=1'b1;
                  end//9
                  else
                  begin//9
                    Valid=1'b0;
                  end//9
                end//8
              end//7
            end//6
          end//5
      end//4
    end//3
  end//2
end//1
endmodule