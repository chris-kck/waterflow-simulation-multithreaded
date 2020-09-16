public class Points{

	float height;
	float waterDepth;
	float waterSurface;

	Points(float height, float waterDepth, float waterSurface){
		this.height = height;
		this.waterDepth = waterDepth;
		this.waterSurface = height;
	}
	float getHeight() {
		return this.height;
	}

	float getWaterDepth() {
		return this.waterDepth;
	}

	float getWaterSurface() {
		return this.waterSurface;
	}

	void setHeight(float newHeight) {
		this.height = newHeight;
	} 
	
	void setWaterDepth(float newWaterDepth) {
		this.waterDepth = newWaterDepth;
		updateWaterSurface();
	}
	void setWaterSurface(float newWaterSurface){
		this.waterSurface = newWaterSurface;
	}

	void updateWaterSurface() {
		this.waterSurface = height + (waterDepth * 0.01f);
		this.waterSurface = (float) Math.round(waterSurface * 100.0) / 100.0f;
		
	}
}
