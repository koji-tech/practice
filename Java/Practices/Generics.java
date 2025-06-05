public class Generics {
    public static void main(String[] args) {
        class Sample<T>{
            private T variable1;
            private T variable2;
            
            public T method(T argument) {
                this.variable1 = argument;
                return this.variable2;
            }
        }
        Sample<String> num = new Sample();
    }
}
