package com.shp.exam.exam1.http.container;

import com.shp.exam.exam1.container.ContainerComponent;
import com.shp.exam.exam1.http.Rq;

public abstract class Controller implements ContainerComponent {
	public abstract void performAction(Rq rq);
}
