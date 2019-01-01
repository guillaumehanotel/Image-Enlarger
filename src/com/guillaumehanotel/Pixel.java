package com.guillaumehanotel;

public class Pixel {
    
    private int hexa;
    
    private int alpha;
    private int red;
    private int green;
    private int blue;
    
    public Pixel(int alpha, int red, int green, int blue){
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.hexa = (this.alpha<<24) | (this.red<<16) | (this.green<<8) | this.blue;
    }
    
    public Pixel(int hexa){
        this.hexa = hexa;
        this.alpha = (hexa & 0xff000000) >> 24;
        this.red = (hexa & 0x00ff0000) >> 16;
        this.green = (hexa & 0x0000ff00) >> 8;
        this.blue = hexa & 0x000000ff;
    }

    public int getHexa() {
        return hexa;
    }
    
    public String toString(){
        String str ="";
        if( (red == blue) && (red == green) && (green == blue) && (red==255) ){
            str+= "0 ";
        } else if( (red == blue) && (red == green) && (green == blue) && (red==61) ){
            str+= "1 ";
        } else if( (red == blue) && (red == green) && (green == blue) && (red==155) ){
            str+= "2 ";
        }
        return str;
    }

}
