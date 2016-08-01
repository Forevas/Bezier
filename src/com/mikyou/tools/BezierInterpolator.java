package com.mikyou.tools;

import android.view.animation.Interpolator;

public class BezierInterpolator implements Interpolator {
	private float factor=0.4f;
	@Override
	public float getInterpolation(float input) {
		// TODO Auto-generated method stub
		return (float) (Math.pow(2, -10 * input) * Math.sin((input - factor / 4) * (2 * Math.PI) / factor) + 1);
	}

}
