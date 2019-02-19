`timescale 1ns/1ns
module tb_vm;
  
  reg CLK, nRESET;
  reg [1:0]Coin;
  reg Select;  
  wire Control; 
  wire Drink;
  wire Change;

 vm uvm( .CLK(CLK),
         .Coin(Coin),
         .Select(Select),
         .nRESET(nRESET),
         .Drink(Drink),
         .Control(Control),
         .Change(Change));
                        
  initial
    forever
      #50 CLK = ~CLK;
  
  initial begin
    CLK = 0; nRESET = 0;
    #50 nRESET = 1;
    #100 Coin = 2'b00; Select = 1; 

    #100 Coin = 2'b11; Select = 1; 
     
    #100 Coin = 2'b01; Select = 0; 
    #100 Coin = 2'b10; Select = 1; 
    
    #100 Coin = 2'b01; Select = 1; 
    
    #100 Coin = 2'b10; Select = 0;
    #100 Coin = 2'b10; Select = 0;
    #100 Coin = 2'b10; Select = 0; 
    #100 Coin = 2'b01; Select = 1; 
    
    #100 Coin = 2'b01; Select = 0; 
    #100 Coin = 2'b10; Select = 0;
    #100 Coin = 2'b10; Select = 1; 
    
    #100 Coin = 2'b10; Select = 0;
    #100 Coin = 2'b10; Select = 0;
    #100 Coin = 2'b01; Select = 1; 
        
    #100 Coin = 2'b10; Select = 1; 
    #100 Coin = 2'b10; Select = 1; 
    $stop;
  end
endmodule