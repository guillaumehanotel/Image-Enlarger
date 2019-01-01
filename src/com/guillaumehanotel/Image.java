package com.guillaumehanotel;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image  {

	private int width;
	private int height;
	private Pixel[][] pixels;

	
	public Image(int width, int height){
		//super(width, height, BufferedImage.TYPE_INT_ARGB);
		this.width = width;
		this.height =  height;
		this.pixels =  new Pixel[this.width][this.height];

	}
	

	public Pixel[][] getPixels() {
		return pixels;
	}
	

	public void init(BufferedImage buff_img){

		for(int x = 0; x < this.width; x++){
			for (int y = 0; y < this.height; y++){

				int clr =  buff_img.getRGB(x,y);
				this.pixels[x][y] = new Pixel(clr);

			}
		}
	}


	public Image enlargeBy(int size){

		Image res = new Image(this.width*size, this.height*size);

		int pointeur_x = 0;
		int pointeur_y = 0;

		for(int x = 0; x < this.width; x++){
			for(int y =0; y < this.height; y++){
				for(int i = pointeur_x; i < size*(y+1); i++){
					for(int j = pointeur_y; j < size*(x+1); j++){
						res.pixels[j][i] = this.pixels[x][y];
					}
				}
				pointeur_x += size;
			}
			pointeur_y += size;
			pointeur_x = 0;
		} 
		return res;
	}


	public BufferedImage getBufferedImage(){
		BufferedImage res = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		for(int i =0; i < this.width; i++){
			for(int j =0; j< this.height; j++){
				res.setRGB(i, j, this.getPixels()[i][j].getHexa());
			}
		}
		return res;
	}


	public String toString(){
		String str = "";
		for(int x = 0; x < this.width; x++){
			for (int y = 0; y < this.height; y++){
				str += this.pixels[y][x].toString();
			}
			str += "\n";
		}
		return str;
	}



}
