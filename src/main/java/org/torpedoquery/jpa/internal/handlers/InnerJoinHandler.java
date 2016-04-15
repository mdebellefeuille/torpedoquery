/**
 * Copyright (C) ${project.inceptionYear} Xavier Jodoin (xavier@jodoin.me)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.torpedoquery.jpa.internal.handlers;

import org.torpedoquery.core.QueryBuilder;
import org.torpedoquery.jpa.internal.Join;
import org.torpedoquery.jpa.internal.joins.InnerJoin;
import org.torpedoquery.jpa.internal.utils.ProxyFactoryFactory;
import org.torpedoquery.jpa.internal.utils.TorpedoMethodHandler;
public class InnerJoinHandler<T> extends JoinHandler<T> {
	/**
	 * <p>Constructor for InnerJoinHandler.</p>
	 *
	 * @param methodHandler a {@link org.torpedoquery.jpa.internal.utils.TorpedoMethodHandler} object.
	 * @param proxyFactoryFactory a {@link org.torpedoquery.jpa.internal.utils.ProxyFactoryFactory} object.
	 */
	public InnerJoinHandler(TorpedoMethodHandler methodHandler, ProxyFactoryFactory proxyFactoryFactory) {
		super(methodHandler, proxyFactoryFactory);
	}

	/**
	 * <p>Constructor for InnerJoinHandler.</p>
	 *
	 * @param fjpaMethodHandler a {@link org.torpedoquery.jpa.internal.utils.TorpedoMethodHandler} object.
	 * @param proxyFactoryFactory a {@link org.torpedoquery.jpa.internal.utils.ProxyFactoryFactory} object.
	 * @param realType a {@link java.lang.Class} object.
	 */
	public InnerJoinHandler(TorpedoMethodHandler fjpaMethodHandler, ProxyFactoryFactory proxyFactoryFactory, Class<T> realType) {
		super(fjpaMethodHandler, proxyFactoryFactory, realType);
	}

	/** {@inheritDoc} */
	@Override
	protected Join createJoin(QueryBuilder queryBuilder, String fieldName) {
		return new InnerJoin(queryBuilder, fieldName);
	}
}
