/**
 *
 *   Copyright 2011 Xavier Jodoin xjodoin@gmail.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.torpedoquery.jpa.internal;

import java.util.Deque;
import java.util.Map;

import org.torpedoquery.jpa.Function;
import org.torpedoquery.jpa.OnGoingMathOperation;

public class MathOperationHandler<T> implements QueryHandler<OnGoingMathOperation<T>>, OnGoingMathOperation<T> {

	private Selector<T> leftSelector;
	private Proxy proxy;

	public MathOperationHandler(Function<T> left) {
		leftSelector = left;
		if (left != null) {
			proxy = (Proxy) left.getProxy();
		}
	}

	@Override
	public OnGoingMathOperation<T> handleCall(Map<Object, QueryBuilder<?>> proxyQueryBuilders, Deque<MethodCall> methods) {

		if (leftSelector == null) {
			MethodCall methodCall = methods.pollFirst();
			proxy = methodCall.getProxy();
			leftSelector = new SimpleMethodCallSelector(proxyQueryBuilders.get(methodCall.getProxy()), methodCall);
		}

		return this;
	}

	@Override
	public Function<T> plus(T right) {

		SimpleMethodCallSelector rightSelector = handleMethodCall();
		return createFunction(rightSelector, "+");
	}

	private SimpleMethodCallSelector handleMethodCall() {
		TorpedoMethodHandler torpedoMethodHandler = TorpedoMagic.getTorpedoMethodHandler();
		MethodCall methodCall = torpedoMethodHandler.getMethods().getFirst();
		SimpleMethodCallSelector rightSelector = new SimpleMethodCallSelector(torpedoMethodHandler.getQueryBuilder(methodCall.getProxy()), methodCall);
		return rightSelector;
	}

	@Override
	public Function<T> plus(Function<T> right) {
		return createFunction(right,"+");
	}

	private MathOperationFunction<T> createFunction(Selector<T> right,String operator) {
		return new MathOperationFunction<T>(proxy, leftSelector, operator, right);
	}

	@Override
	public Function<T> subtract(T right) {
		SimpleMethodCallSelector rightSelector = handleMethodCall();
		return createFunction(rightSelector, "-");
	}

	@Override
	public Function<T> subtract(Function<T> right) {
		return createFunction(right,"-");
	}

	@Override
	public Function<T> multiply(T right) {
		SimpleMethodCallSelector rightSelector = handleMethodCall();
		return createFunction(rightSelector, "*");
	}

	@Override
	public Function<T> multiply(Function<T> right) {
		return createFunction(right,"*");
	}

	@Override
	public Function<T> divide(T right) {
		SimpleMethodCallSelector rightSelector = handleMethodCall();
		return createFunction(rightSelector, "/");
	}

	@Override
	public Function<T> divide(Function<T> right) {
		return createFunction(right,"/");
	}

}
