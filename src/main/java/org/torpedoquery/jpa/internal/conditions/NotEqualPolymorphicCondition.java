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

package org.torpedoquery.jpa.internal.conditions;

import org.torpedoquery.jpa.internal.Selector;
public class NotEqualPolymorphicCondition<T> extends PolymorphicCondition<T> {

	/**
	 * <p>Constructor for NotEqualPolymorphicCondition.</p>
	 *
	 * @param selector a {@link org.torpedoquery.jpa.internal.Selector} object.
	 * @param condition a {@link java.lang.Class} object.
	 */
	public NotEqualPolymorphicCondition(Selector selector,
			Class<? extends T> condition) {
		super(selector, condition);
	}

	/** {@inheritDoc} */
	@Override
	protected String getComparator() {
		return NotEqualCondition.NOT_EQUAL;
	}

}
