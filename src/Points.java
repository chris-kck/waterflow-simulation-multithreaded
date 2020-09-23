public class Points{

	volatile float height;
	volatile float waterDepth;
	volatile float waterSurface;

	Points(float height, float waterDepth, float waterSurface){
		this.height = height;
		this.waterDepth = waterDepth;
		this.waterSurface = height;
	}
	synchronized float getHeight() {
		return this.height;
	}

	synchronized float getWaterDepth() {
		return this.waterDepth;
	}

	synchronized float getWaterSurface() {
		return this.waterSurface;
	}

	synchronized void setHeight(float newHeight) {
		this.height = newHeight;
	} 
	
	synchronized void setWaterDepth(float newWaterDepth) {
		this.waterDepth = newWaterDepth;
		updateWaterSurface();
	}
	synchronized void setWaterSurface(float newWaterSurface){
		this.waterSurface = newWaterSurface;
	}

	synchronized void updateWaterSurface() {
		this.waterSurface = height + (waterDepth * 0.01f);
		this.waterSurface = (float) Math.round(waterSurface * 100.0) / 100.0f;
		
	}
}
