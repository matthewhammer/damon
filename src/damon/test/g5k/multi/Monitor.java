/*******************************************************************************
 * Damon : a Distributed AOP Middleware on top of a p2p Overlay Network
 * Copyright (C) 2006-2008 Ruben Mondejar
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 ******************************************************************************/
package damon.test.g5k.multi;

import rice.p2p.commonapi.NodeHandle;

import damon.annotation.*;
import damon.invokation.RemoteJoinPoint;
import damon.invokation.aspectwerkz.AspectRemoting;

/**
 * Distributed Aspect using multi abstraction and remote services
 * @author Rub�n Mond�jar <ruben.mondejar@urv.cat>
 */
@DistributedAspect (abstraction = Abstractions.LOCAL, target = "p2p://test.urv.cat")
public class Monitor extends AspectRemoting {
	
	@RemoteAdvice(id = "information")
	public void storeTime(RemoteJoinPoint rjp, String name, NodeHandle nh, int[] data1, int[] data2) {
		if (name!=null) {
          MonitorHost.updateData(name, data1[0], data1[1], data1[2], data2[0], data2[1], data2[2]);
		} 
	}		
	
}	