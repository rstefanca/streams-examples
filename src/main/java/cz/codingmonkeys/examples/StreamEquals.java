package cz.codingmonkeys.examples;

import java.util.Objects;
import java.util.Optional;

/**
 * @author rstefanca
 */
public class StreamEquals {

	private static class Entity {
		private final String s1, s2;

		private Entity(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public boolean equals(Object o) {
			return Optional.of(o)
					.filter(that -> that instanceof Entity)
					.map(that -> (Entity)that)
					.filter(that -> Objects.equals(this.s1, that.s1))
					.filter(that -> Objects.equals(this.s2, that.s2))
					.isPresent();
		}
	}

	public static void main(String[] args) {
		System.out.println(new Entity("aaa", "bbb").equals(new Entity("bbb", "aaa")));
		System.out.println(new Entity("aaa", "bbb").equals(new Entity("aaa", "bbb")));
	}
}
