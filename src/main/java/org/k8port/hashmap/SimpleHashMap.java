package org.k8port.hashmap;

public class SimpleHashMap {

    static class CustomKey {

        private final int id;

        public CustomKey(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CustomKey customKey = (CustomKey) o;
            return id == customKey.id;
        }
    }
}
