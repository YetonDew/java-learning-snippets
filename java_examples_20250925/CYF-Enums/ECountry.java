public enum ECountry {

    PL(313)  {
        public String getCapital() { return "Warsaw";   }
        public String toString()   { return "Poland";   }
    },

    FR(675) {
        public String getCapital() { return "Paris";    }
        public String toString()   { return "France";   }
    },

    IT(301) {
        public String getCapital() { return "Rome";     }
        public String toString()   { return "Italy";    }
    },

    HU(93) {
        public String getCapital() { return "Budapest"; }
        public String toString()   { return "Hungary";  }
    },

    GE(357) {
        public String getCapital() { return "Berlin";   }
        public String toString()   { return "Germany";  }
    }; // <-- semicolon here!

    // can be private - no new objects can be created anyway
    private ECountry(int a) {
        area = a;
    }

    private int area; // in thousands of square km

    abstract public String getCapital();
    public int getArea(){ return area; }

}
