package sgctool;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Romhack {
    
    RandomAccessFile rom, texto;
    int ponteiros[][] = new int[512][2];
    int quantidade, z;
    
    Romhack (RandomAccessFile rom, RandomAccessFile texto) {
      
        this.rom = rom;
        this.texto = texto;
        
    }
    
    public void extrair() {
        
        //Bloco 3
        calcularPonteiros(90128, 90477, 0xC010);
        try { texto.writeBytes("{" + Integer.toString(ponteiros[0][0]) + "}\r\n\r\n"); } catch (IOException ioe) {}
        for (z = 0; z < quantidade; z++)
            descompactar(ponteiros[z][0], true);
        
        //Bloco 2
        calcularPonteiros(65552, 66063, 0x8010);
        try { texto.writeBytes("{" + Integer.toString(ponteiros[0][0]) + "}\r\n\r\n"); } catch (IOException ioe) {}
        for (z = 0; z < quantidade; z++)
            descompactar(ponteiros[z][0], true);
        
        //Bloco 1
        calcularPonteiros(32784, 33295, 0x10);
        try { texto.writeBytes("{" + Integer.toString(ponteiros[0][0]) + "}\r\n\r\n"); } catch (IOException ioe) {}
        for (z = 0; z < quantidade; z++)
            descompactar(ponteiros[z][0], true);
        
        //Bloco Itens
        for (z = 77840; z < 79951; z = z + 8) {
            try { texto.writeBytes("{" + Integer.toString(z) + "}\r\n\r\n"); } catch (IOException ioe) {}
            descompactar(z, false);
        }
        
    }
    
    public void inserir() {
        
        compactar();
        
    }
    
    private void calcularPonteiros(int inicioBloco, int finalBloco, int baseCalculo) {
        
        int x, y, ponteiro1, ponteiro2;
         
        quantidade = 0;
        try {
            rom.seek(inicioBloco);
            for (x = inicioBloco; x < finalBloco; x = x + 2) {
                ponteiro1 = rom.readUnsignedByte();
                ponteiro2 = rom.readUnsignedByte();
                ponteiros[quantidade][0] = (ponteiro2 * 256 + ponteiro1) + baseCalculo;
                ponteiros[quantidade][1] = x;
                quantidade++;
            }       
        } catch (IOException ioe) {
                
              }
        
        ponteiros[quantidade][0] = ponteiros[quantidade - 1][0] + 128;
        
    }
    
    private void descompactar (int inicioBloco, boolean escreverPonteiros) {
        
        String binario = "", bits = "";
        int posicao = 0, x;
        boolean finalSequencia = false;
        
        //Primeiro lemos cada byte, convertemos e adicionamos em uma string binária
        try {

            rom.seek(inicioBloco);
            while (bits.length() < 5000) {
                binario = Integer.toBinaryString(rom.readUnsignedByte());
                for (x = binario.length(); x < 8; x++)
                    bits = bits.concat("0");
                bits = bits.concat(binario);
            }
            
        } catch (IOException ioe) {
            
          }
        
       //Logo vamos decodificar a string e salvar no arquivo texto
       try {
       if (escreverPonteiros == true)    
            texto.writeBytes("[" + Integer.toString(ponteiros[z][1]) + "]\r\n");
       while ((posicao < bits.length() - 5) && (finalSequencia == false)) {
           switch (Integer.valueOf(bits.substring(posicao, posicao + 5), 2)) {
               case 0:
                    texto.writeByte('A');
                    posicao = posicao + 5;
                    break;
               case 1:
                    texto.writeByte('B');
                    posicao = posicao + 5;
                    break;
               case 2:
                    texto.writeByte('C');
                    posicao = posicao + 5;
                    break;
               case 3:
                    texto.writeByte('D');
                    posicao = posicao + 5;
                    break;
               case 4:
                    texto.writeByte('E');
                    posicao = posicao + 5;
                    break;
               case 5:
                    texto.writeByte('F');
                    posicao = posicao + 5;
                    break;
               case 6:
                    texto.writeByte('G');
                    posicao = posicao + 5;
                    break;
               case 7:
                    texto.writeByte('H');
                    posicao = posicao + 5;
                    break;
               case 8:
                    texto.writeByte('I');
                    posicao = posicao + 5;
                    break;
               case 9:
                    texto.writeByte('J');
                    posicao = posicao + 5;
                    break;
               case 10:
                    texto.writeByte('K');
                    posicao = posicao + 5;
                    break;
               case 11:
                    texto.writeByte('L');
                    posicao = posicao + 5;
                    break;
               case 12:
                    texto.writeByte('M');
                    posicao = posicao + 5;
                    break;
               case 13:
                    texto.writeByte('N');
                    posicao = posicao + 5;
                    break;
               case 14:
                    texto.writeByte('O');
                    posicao = posicao + 5;
                    break;
               case 15:
                    texto.writeByte('P');
                    posicao = posicao + 5;
                    break;
               case 16:
                    texto.writeByte('Q');
                    posicao = posicao + 5;
                    break;
               case 17:
                    texto.writeByte('R');
                    posicao = posicao + 5;
                    break;
               case 18:
                    texto.writeByte('S');
                    posicao = posicao + 5;
                    break;
               case 19:
                    texto.writeByte('T');
                    posicao = posicao + 5;
                    break;
               case 20:
                    texto.writeByte('U');
                    posicao = posicao + 5;
                    break;
               case 21:
                    texto.writeByte('V');
                    posicao = posicao + 5;
                    break;
               case 22:
                    texto.writeByte('W');
                    posicao = posicao + 5;
                    break;
               case 23:
                    texto.writeByte('X');
                    posicao = posicao + 5;
                    break;
               case 24:
                    texto.writeByte('Y');
                    posicao = posicao + 5;
                    break;
               case 25:
                    texto.writeByte('Z');
                    posicao = posicao + 5;
                    break;
               case 26:
                    texto.writeByte(' ');
                    posicao = posicao + 5;
                    break;
               case 27:
                    texto.writeBytes("<pause>\r\n");
                    posicao = posicao + 5;
                    break;
               case 28:
                    texto.writeBytes("<open>\r\n");
                    posicao = posicao + 5;
                    break;
               case 29:
                    texto.writeBytes("<break>\r\n");
                    posicao = posicao + 5;
                    break;
               case 30:
                    posicao = posicao + 5;
                    switch (Integer.valueOf(bits.substring(posicao, posicao + 5), 2)) {
                        case 0:
                            texto.writeByte('.');
                            posicao = posicao + 5;
                            break;
                        case 1:
                            texto.writeByte('-');
                            posicao = posicao + 5;
                            break;
                        case 2:
                            texto.writeByte('°');
                            posicao = posicao + 5;
                            break;
                        case 3:
                            texto.writeByte('=');
                            posicao = posicao + 5;
                            break;
                        case 4:
                            texto.writeByte(':');
                            posicao = posicao + 5;
                            break;
                        case 5:
                            texto.writeByte(',');
                            posicao = posicao + 5;
                            break;
                        case 6:
                            texto.writeByte('"');
                            posicao = posicao + 5;
                            break;
                        case 7:
                            texto.writeByte('!');
                            posicao = posicao + 5;
                            break;
                        case 8:
                            texto.writeByte('?');
                            posicao = posicao + 5;
                            break;
                        case 9:
                            texto.writeByte(';');
                            posicao = posicao + 5;
                            break;
                        case 10:
                            texto.writeBytes("'");
                            posicao = posicao + 5;
                            break;
                        case 16:
                            texto.writeByte('0');
                            posicao = posicao + 5;
                            break;
                        case 17:
                            texto.writeByte('1');
                            posicao = posicao + 5;
                            break;
                        case 18:
                            texto.writeByte('2');
                            posicao = posicao + 5;
                            break;
                        case 19:
                            texto.writeByte('3');
                            posicao = posicao + 5;
                            break;
                        case 20:
                            texto.writeByte('4');
                            posicao = posicao + 5;
                            break;
                        case 21:
                            texto.writeByte('5');
                            posicao = posicao + 5;
                            break;
                        case 22:
                            texto.writeByte('6');
                            posicao = posicao + 5;
                            break;
                        case 23:
                            texto.writeByte('7');
                            posicao = posicao + 5;
                            break;
                        case 24:
                            texto.writeByte('8');
                            posicao = posicao + 5;
                            break;
                        case 25:
                            texto.writeByte('9');
                            posicao = posicao + 5;
                            break;
                        case 26:
                            texto.writeByte('*');
                            posicao = posicao + 5;
                            break;
                        case 27:
                            texto.writeByte('*');
                            posicao = posicao + 5;
                            break;
                        case 28:
                            posicao = posicao + 5;
                            texto.writeBytes(" <" + bits.substring(posicao - 10, posicao + 8) + "> ");
                            posicao = posicao + 8;
                            break;
                        case 29:
                            posicao = posicao + 5;
                            switch (Integer.valueOf(bits.substring(posicao, posicao + 8), 2)) {
                                case 0:
                                    texto.writeBytes(" YOU ");
                                    posicao = posicao + 8;
                                    break;
                                case 1:
                                    texto.writeBytes(" YOUR ");
                                    posicao = posicao + 8;
                                    break;
                                case 2:
                                    texto.writeBytes(" THIS ");
                                    posicao = posicao + 8;
                                    break;
                                case 3:
                                    texto.writeBytes(" THE ");
                                    posicao = posicao + 8;
                                    break;
                                case 4:
                                    texto.writeBytes(" TORCH ");
                                    posicao = posicao + 8;
                                    break;
                                case 5:
                                    texto.writeBytes(" ROOM ");
                                    posicao = posicao + 8;
                                    break;
                                case 6:
                                    texto.writeBytes("THIS ");
                                    posicao = posicao + 8;
                                    break;
                                case 7:
                                    texto.writeBytes("THAT ");
                                    posicao = posicao + 8;
                                    break;    
                                default:
                                    texto.writeBytes(" <" + bits.substring(posicao - 10, posicao + 8) + "> ");
                                    posicao = posicao + 8;
                            }
                            break;
                        case 30:
                            posicao = posicao + 10;
                            switch (Integer.valueOf(bits.substring(posicao, posicao + 4), 2)) {
                                case 0:
                                    posicao = posicao + 4;
                                    switch (Integer.valueOf(bits.substring(posicao, posicao + 4), 2)) {
                                        case 5:
                                            texto.writeBytes("<" + bits.substring(posicao - 19, posicao + 14) + ">");
                                            posicao = posicao + 14;
                                            break;
                                        case 10:
                                            texto.writeBytes("<" + bits.substring(posicao - 19, posicao + 13) + ">");
                                            posicao = posicao + 13;
                                            break;
                                        default:
                                            texto.writeBytes("<" + bits.substring(posicao - 19, posicao + 12) + ">");
                                            posicao = posicao + 12;
                                    }
                                    break;
                                case 1:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 16) + ">");
                                    posicao = posicao + 16;
                                    break;
                                case 4:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 12) + ">");
                                    posicao = posicao + 12;
                                    break;
                                case 5:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 14) + ">");
                                    posicao = posicao + 14;
                                    break;
                                case 8:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 11) + ">");
                                    posicao = posicao + 11;
                                    break;
                                case 10:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 13) + ">");
                                    posicao = posicao + 13;
                                    break;
                                case 20:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 9) + ">");
                                    posicao = posicao + 9;
                                    break;
                                default:
                                    texto.writeBytes("<" + bits.substring(posicao - 15, posicao + 14) + ">");
                                    posicao = posicao + 14;
                            }
                           
                            break;
                        case 31:
                            texto.writeBytes(" <" + bits.substring(posicao - 10, posicao + 8) + "> ");
                            posicao = posicao + 8;
                            break;
                        default:
                            texto.writeBytes(" <" + bits.substring(posicao - 10, posicao + 5) + "> ");
                            posicao = posicao + 5;
                    }
                    break;
               case 31:
                    texto.writeBytes("<end>\r\n__________________________\r\n");
                    finalSequencia = true;
                    posicao = posicao + 5;
                    break;
               default:
                    texto.writeBytes(" <" + bits.substring(posicao, posicao + 5) + "> ");
                    posicao = posicao + 5;
           }
       }
           
       } catch (IOException ioe) {
            
        }   
           
    }
    
    private void compactar() {
       
        String palavra, bits = "";
        long ponteiroDeArquivo;
        int baseCalculo = 0;
        try {
            
            while (texto.getFilePointer() < texto.length()) {
                palavra = new String(new byte[] {texto.readByte()}, StandardCharsets.ISO_8859_1);
                if (palavra.equals("{")) {
                    for (int x = 0; x < 6; x++)
                        palavra = palavra.concat(new String(new byte[] {texto.readByte()}, StandardCharsets.ISO_8859_1));
                    palavra = palavra.replace("{", "");
                    palavra = palavra.replace("}", "");
                    rom.seek(Integer.valueOf(palavra));
                    if (palavra.equals("33296"))
                        baseCalculo = 0x10;
                    if (palavra.equals("66064"))
                        baseCalculo = 0x8010;
                    if (palavra.equals("90640"))
                        baseCalculo = 0xC010;
                }
                
                if (palavra.equals("[")) {
                    for (int x = 0; x < 6; x++)
                        palavra = palavra.concat(new String(new byte[] {texto.readByte()}, StandardCharsets.ISO_8859_1));
                    palavra = palavra.replace("[", "");
                    palavra = palavra.replace("]", "");
                    ponteiroDeArquivo = rom.getFilePointer();
                    rom.seek(Integer.valueOf(palavra));
                    rom.writeShort(Short.reverseBytes((short)(ponteiroDeArquivo - baseCalculo)));
                    rom.seek(ponteiroDeArquivo);
                }  
                
                if (palavra.equals("A"))
                    bits = bits.concat("00000");
                if (palavra.equals("B"))
                    bits = bits.concat("00001");
                if (palavra.equals("C"))
                    bits = bits.concat("00010");
                if (palavra.equals("D"))
                    bits = bits.concat("00011");
                if (palavra.equals("E"))
                    bits = bits.concat("00100");
                if (palavra.equals("F"))
                    bits = bits.concat("00101");
                if (palavra.equals("G"))
                    bits = bits.concat("00110");
                if (palavra.equals("H"))
                    bits = bits.concat("00111");
                if (palavra.equals("I"))
                    bits = bits.concat("01000");
                if (palavra.equals("J"))
                    bits = bits.concat("01001");
                if (palavra.equals("K"))
                    bits = bits.concat("01010");
                if (palavra.equals("L"))
                    bits = bits.concat("01011");
                if (palavra.equals("M"))
                    bits = bits.concat("01100");
                if (palavra.equals("N"))
                    bits = bits.concat("01101");
                if (palavra.equals("O"))
                    bits = bits.concat("01110");
                if (palavra.equals("P"))
                    bits = bits.concat("01111");
                if (palavra.equals("Q"))
                    bits = bits.concat("10000");
                if (palavra.equals("R"))
                    bits = bits.concat("10001");
                if (palavra.equals("S"))
                    bits = bits.concat("10010");
                if (palavra.equals("T"))
                    bits = bits.concat("10011");
                if (palavra.equals("U"))
                    bits = bits.concat("10100");
                if (palavra.equals("V"))
                    bits = bits.concat("10101");
                if (palavra.equals("W"))
                    bits = bits.concat("10110");
                if (palavra.equals("X"))
                    bits = bits.concat("10111");
                if (palavra.equals("Y"))
                    bits = bits.concat("11000");
                if (palavra.equals("Z"))
                    bits = bits.concat("11001");
                if (palavra.equals(" "))
                    bits = bits.concat("11010");
                if (palavra.equals("<")) {
                    while (!palavra.endsWith(">"))
                        palavra = palavra.concat(new String(new byte[] {texto.readByte()}, StandardCharsets.ISO_8859_1));
                    palavra = palavra.replace("<", "");
                    palavra = palavra.replace(">", "");
                    if (palavra.equals("pause"))
                        bits = bits.concat("11011");
                    if (palavra.equals("open"))
                        bits = bits.concat("11100");
                    if (palavra.equals("break"))
                        bits = bits.concat("11101");
                    if (palavra.equals("end")) {
                        bits = bits.concat("11111");
                        for (int y = 0; y < bits.length(); y = y + 8) {
                            if ((bits.length() - y) < 8)
                                while ((bits.length() - y) < 8)
                                    bits = bits.concat("0");
                            rom.writeByte((byte)(Integer.parseInt(bits.substring(y, y + 8), 2)));
                        }
                        bits = "";
                        
                    }
                    if (palavra.charAt(0) == '1')
                        bits = bits.concat(palavra);
                    //if (palavra.charAt(0) == 'O')
                    //    bits = bits.concat("111101110100000000");
                }
                if (palavra.equals("."))
                    bits = bits.concat("1111000000");
                if (palavra.equals("-"))
                    bits = bits.concat("1111000001");
                if (palavra.equals("º"))
                    bits = bits.concat("1111000010");
                if (palavra.equals("="))
                    bits = bits.concat("1111000011");
                if (palavra.equals(":"))
                    bits = bits.concat("1111000100");
                if (palavra.equals(","))
                    bits = bits.concat("1111000101");
                if (palavra.charAt(0) == '"')
                    bits = bits.concat("1111000110");
                if (palavra.equals("!"))
                    bits = bits.concat("1111000111");
                if (palavra.equals("?"))
                    bits = bits.concat("1111001000");
                if (palavra.equals(";"))
                    bits = bits.concat("1111001001");
                if (palavra.equals("'"))
                    bits = bits.concat("1111001010");
                if (palavra.equals("0"))
                    bits = bits.concat("1111010000");
                if (palavra.equals("1"))
                    bits = bits.concat("1111010001");
                if (palavra.equals("2"))
                    bits = bits.concat("1111010010");
                if (palavra.equals("3"))
                    bits = bits.concat("1111010011");
                if (palavra.equals("4"))
                    bits = bits.concat("1111010100");
                if (palavra.equals("5"))
                    bits = bits.concat("1111010101");
                if (palavra.equals("6"))
                    bits = bits.concat("1111010110");
                if (palavra.equals("7"))
                    bits = bits.concat("1111010111");
                if (palavra.equals("8"))
                    bits = bits.concat("1111011000");
                if (palavra.equals("9"))
                    bits = bits.concat("1111011001");        
            }
                     
        } catch (IOException ioe) {  
          }
    }

}
