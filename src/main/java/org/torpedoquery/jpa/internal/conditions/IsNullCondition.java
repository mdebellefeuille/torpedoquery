
/**
 * Copyright (C) 2011 Xavier Jodoin (xavier@jodoin.me)
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
 *
 * @author xjodoin
 * @version $Id: $Id
 */
package org.torpedoquery.jpa.internal.conditions;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.torpedoquery.jpa.internal.Condition;
import org.torpedoquery.jpa.internal.Selector;
public class IsNullCondition implements Condition {

	private final Selector selector;

	/**
	 * <p>Constructor for IsNullCondition.</p>
	 *
	 * @param selector a {@link org.torpedoquery.jpa.internal.Selector} object.
	 */
	public IsNullCondition(Selector selector) {
		this.selector = selector;
	}

	/** {@inheritDoc} */
	@Override
	public String createQueryFragment(AtomicInteger incrementor) {
		return selector.createQueryFragment(incrementor) + " is null";
	}

	/** {@inheritDoc} */
	@Override
	public List getParameters() {
		return Collections.emptyList();
	}
}
