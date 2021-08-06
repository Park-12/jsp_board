package com.shp.exam.exam1.interceptor;

import com.shp.exam.exam1.container.ContainerComponent;
import com.shp.exam.exam1.http.Rq;

public abstract class Interceptor implements ContainerComponent {
	abstract public boolean runBeforeAction(Rq rq);
}
