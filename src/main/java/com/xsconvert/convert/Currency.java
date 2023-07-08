package com.xsconvert.convert;

import java.util.ArrayList;
import java.util.Collections;

public class Currency implements Comparable<Currency> {

    private String code, name;
    private double rate, amount;

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Currency(String code) {
        this.code = code;
        this.name = findName();
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String findName() {
            for(Currency currency : getAvailCurrencies()) {
                if (this.equals(currency)) {
                    return currency.getName();
                }
            } throw new IllegalArgumentException("Invalid currency code");
    }

    public double getRate() {
        return this.rate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setCode(String code) {
        this.code = code;
        this.name = findName();
        this.amount = rate > 0 ? 0 : this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    private final static ArrayList<Currency> Availcurrencies = new ArrayList<Currency>();
    private static void initAvailCurrencies() {
        Availcurrencies.add(new Currency("STN", "Dobra santotomense"));
        Availcurrencies.add(new Currency("XAG", "Silver (troy ounce)"));
        Availcurrencies.add(new Currency("XAU", "Gold (troy ounce)"));
        Availcurrencies.add(new Currency("PLN", "Złoty"));
        Availcurrencies.add(new Currency("UGX", "Chelín ugandés"));
        Availcurrencies.add(new Currency("GGP", "Libra de Guernsey"));
        Availcurrencies.add(new Currency("MWK", "Kwacha malauí"));
        Availcurrencies.add(new Currency("NAD", "Dólar namibio"));
        Availcurrencies.add(new Currency("ALL", "Lek albanés"));
        Availcurrencies.add(new Currency("BHD", "Dinar bareiní"));
        Availcurrencies.add(new Currency("JEP", "Libra de Jersey"));
        Availcurrencies.add(new Currency("BWP", "Pula (moneda)"));
        Availcurrencies.add(new Currency("MRU", "Uguiya"));
        Availcurrencies.add(new Currency("BMD", "Dólar bermudeño"));
        Availcurrencies.add(new Currency("MNT", "Tugrik mongol"));
        Availcurrencies.add(new Currency("FKP", "Libra malvinense"));
        Availcurrencies.add(new Currency("PYG", "Guaraní (moneda)"));
        Availcurrencies.add(new Currency("AUD", "Dólar australiano"));
        Availcurrencies.add(new Currency("KYD", "Dólar de las Islas Caimán"));
        Availcurrencies.add(new Currency("RWF", "Franco ruandés"));
        Availcurrencies.add(new Currency("WST", "Tālā (moneda)"));
        Availcurrencies.add(new Currency("SHP", "Libra de Santa Elena"));
        Availcurrencies.add(new Currency("SOS", "Chelín somalí"));
        Availcurrencies.add(new Currency("SSP", "Libra sursudanesa"));
        Availcurrencies.add(new Currency("BIF", "Franco burundés"));
        Availcurrencies.add(new Currency("SEK", "Corona sueca"));
        Availcurrencies.add(new Currency("CUC", "Peso cubano convertible"));
        Availcurrencies.add(new Currency("BTN", "Ngultrum butanés"));
        Availcurrencies.add(new Currency("MOP", "Pataca macaense"));
        Availcurrencies.add(new Currency("XDR", "Derechos especiales de giro"));
        Availcurrencies.add(new Currency("IMP", "Libra manesa"));
        Availcurrencies.add(new Currency("INR", "Rupia india"));
        Availcurrencies.add(new Currency("BYN", "Rublo bielorruso"));
        Availcurrencies.add(new Currency("BOB", "Boliviano (moneda)"));
        Availcurrencies.add(new Currency("SRD", "Dólar surinamés"));
        Availcurrencies.add(new Currency("GEL", "Lari georgiano"));
        Availcurrencies.add(new Currency("ZWL", "Dólar zimbabuense"));
        Availcurrencies.add(new Currency("EUR", "Euro"));
        Availcurrencies.add(new Currency("BBD", "Dólar de Barbados"));
        Availcurrencies.add(new Currency("RSD", "Dinar serbio"));
        Availcurrencies.add(new Currency("SDG", "Libra sudanesa"));
        Availcurrencies.add(new Currency("VND", "Đồng vietnamita"));
        Availcurrencies.add(new Currency("VES", "Bolívar (moneda)"));
        Availcurrencies.add(new Currency("ZMW", "Kwacha zambiano"));
        Availcurrencies.add(new Currency("KGS", "Som kirguís"));
        Availcurrencies.add(new Currency("HUF", "Forinto húngaro"));
        Availcurrencies.add(new Currency("BND", "Dólar de Brunéi"));
        Availcurrencies.add(new Currency("BAM", "Marco bosnioherzegovino"));
        Availcurrencies.add(new Currency("CVE", "Escudo caboverdiano"));
        Availcurrencies.add(new Currency("BGN", "Leva (moneda)"));
        Availcurrencies.add(new Currency("NOK", "Corona noruega"));
        Availcurrencies.add(new Currency("BRL", "Real brasileño"));
        Availcurrencies.add(new Currency("JPY", "Yen"));
        Availcurrencies.add(new Currency("HRK", "Kuna croata"));
        Availcurrencies.add(new Currency("HKD", "Dólar de Hong Kong"));
        Availcurrencies.add(new Currency("ISK", "Corona islandesa"));
        Availcurrencies.add(new Currency("IDR", "Rupia indonesia"));
        Availcurrencies.add(new Currency("KRW", "Won surcoreano"));
        Availcurrencies.add(new Currency("KHR", "Riel camboyano"));
        Availcurrencies.add(new Currency("XAF", "Franco CFA de África Central"));
        Availcurrencies.add(new Currency("CHF", "Franco suizo"));
        Availcurrencies.add(new Currency("MXN", "Peso mexicano"));
        Availcurrencies.add(new Currency("PHP", "Peso filipino"));
        Availcurrencies.add(new Currency("RON", "Leu rumano"));
        Availcurrencies.add(new Currency("RUB", "Rublo ruso"));
        Availcurrencies.add(new Currency("SGD", "Dólar de Singapur"));
        Availcurrencies.add(new Currency("AED", "Dírham de los Emiratos Árabes Unidos"));
        Availcurrencies.add(new Currency("KWD", "Dinar kuwaití"));
        Availcurrencies.add(new Currency("CAD", "Dólar canadiense"));
        Availcurrencies.add(new Currency("PKR", "Rupia pakistaní"));
        Availcurrencies.add(new Currency("CLP", "Peso (moneda de Chile)"));
        Availcurrencies.add(new Currency("CNY", "Renminbi"));
        Availcurrencies.add(new Currency("COP", "Peso colombiano"));
        Availcurrencies.add(new Currency("AOA", "Kwanza angoleño"));
        Availcurrencies.add(new Currency("KMF", "Franco comorense"));
        Availcurrencies.add(new Currency("CRC", "Colón (moneda de Costa Rica)"));
        Availcurrencies.add(new Currency("CUP", "Peso cubano"));
        Availcurrencies.add(new Currency("GNF", "Franco guineano"));
        Availcurrencies.add(new Currency("NZD", "Dólar neozelandés"));
        Availcurrencies.add(new Currency("EGP", "Libra egipcia"));
        Availcurrencies.add(new Currency("DJF", "Franco yibutiano"));
        Availcurrencies.add(new Currency("ANG", "Florín antillano neerlandés"));
        Availcurrencies.add(new Currency("DOP", "Peso dominicano"));
        Availcurrencies.add(new Currency("JOD", "Dinar jordano"));
        Availcurrencies.add(new Currency("AZN", "Manat azerbaiyano"));
        Availcurrencies.add(new Currency("SVC", "Colón (moneda de El Salvador)"));
        Availcurrencies.add(new Currency("NGN", "Naira"));
        Availcurrencies.add(new Currency("ERN", "Nakfa"));
        Availcurrencies.add(new Currency("SZL", "Lilangeni"));
        Availcurrencies.add(new Currency("DKK", "Corona danesa"));
        Availcurrencies.add(new Currency("ETB", "Birr etíope"));
        Availcurrencies.add(new Currency("FJD", "Dólar fiyiano"));
        Availcurrencies.add(new Currency("XPF", "Franco CFP"));
        Availcurrencies.add(new Currency("GMD", "Dalasi"));
        Availcurrencies.add(new Currency("AFN", "Afgani afgano"));
        Availcurrencies.add(new Currency("GHS", "Cedi"));
        Availcurrencies.add(new Currency("GIP", "Libra gibraltareña"));
        Availcurrencies.add(new Currency("GTQ", "Quetzal (moneda)"));
        Availcurrencies.add(new Currency("HNL", "Lempira (moneda)"));
        Availcurrencies.add(new Currency("GYD", "Dólar guyanés"));
        Availcurrencies.add(new Currency("HTG", "Gourde (moneda de Haití)"));
        Availcurrencies.add(new Currency("XCD", "Dólar del Caribe Oriental"));
        Availcurrencies.add(new Currency("GBP", "Libra esterlina"));
        Availcurrencies.add(new Currency("AMD", "Dram armenio"));
        Availcurrencies.add(new Currency("IRR", "Rial iraní"));
        Availcurrencies.add(new Currency("JMD", "Dólar jamaiquino"));
        Availcurrencies.add(new Currency("IQD", "Dinar iraquí"));
        Availcurrencies.add(new Currency("KZT", "Tenge kazajo"));
        Availcurrencies.add(new Currency("KES", "Chelín keniano"));
        Availcurrencies.add(new Currency("ILS", "Nuevo séquel"));
        Availcurrencies.add(new Currency("LYD", "Dinar libio"));
        Availcurrencies.add(new Currency("LSL", "Loti"));
        Availcurrencies.add(new Currency("LBP", "Libra libanesa"));
        Availcurrencies.add(new Currency("LRD", "Dólar liberiano"));
        Availcurrencies.add(new Currency("AWG", "Florín arubeño"));
        Availcurrencies.add(new Currency("MKD", "Denar normacedonio"));
        Availcurrencies.add(new Currency("LAK", "Kip laosiano"));
        Availcurrencies.add(new Currency("MGA", "Ariary malgache"));
        Availcurrencies.add(new Currency("ZAR", "Rand sudafricano"));
        Availcurrencies.add(new Currency("MDL", "Leu moldavo"));
        Availcurrencies.add(new Currency("MVR", "Rupia de Maldivas"));
        Availcurrencies.add(new Currency("MUR", "Rupia de Mauricio"));
        Availcurrencies.add(new Currency("MMK", "Kyat birmano"));
        Availcurrencies.add(new Currency("MAD", "Dírham marroquí"));
        Availcurrencies.add(new Currency("XOF", "Franco CFA de África Occidental"));
        Availcurrencies.add(new Currency("MZN", "Metical mozambiqueño"));
        Availcurrencies.add(new Currency("MYR", "Ringgit"));
        Availcurrencies.add(new Currency("OMR", "Rial omaní"));
        Availcurrencies.add(new Currency("NIO", "Córdoba (moneda de Nicaragua)"));
        Availcurrencies.add(new Currency("NPR", "Rupia nepalí"));
        Availcurrencies.add(new Currency("PAB", "Balboa (moneda de Panamá)"));
        Availcurrencies.add(new Currency("PGK", "Kina (moneda)"));
        Availcurrencies.add(new Currency("PEN", "Sol (moneda del Perú)"));
        Availcurrencies.add(new Currency("ARS", "Peso (moneda de Argentina)"));
        Availcurrencies.add(new Currency("SAR", "Riyal saudí"));
        Availcurrencies.add(new Currency("QAR", "Riyal catarí"));
        Availcurrencies.add(new Currency("SCR", "Rupia seychelense"));
        Availcurrencies.add(new Currency("SLL", "Leone"));
        Availcurrencies.add(new Currency("LKR", "Rupia de Sri Lanka"));
        Availcurrencies.add(new Currency("SBD", "Dólar de las Islas Salomón"));
        Availcurrencies.add(new Currency("VUV", "Vatu"));
        Availcurrencies.add(new Currency("USD", "Dólar estadounidense"));
        Availcurrencies.add(new Currency("DZD", "Dinar argelino"));
        Availcurrencies.add(new Currency("BDT", "Taka bangladesí"));
        Availcurrencies.add(new Currency("BSD", "Dólar bahameño"));
        Availcurrencies.add(new Currency("BZD", "Dólar beliceño"));
        Availcurrencies.add(new Currency("CDF", "Franco congoleño"));
        Availcurrencies.add(new Currency("UAH", "Grivna"));
        Availcurrencies.add(new Currency("YER", "Rial yemení"));
        Availcurrencies.add(new Currency("TMT", "Manat turcomano"));
        Availcurrencies.add(new Currency("UZS", "Som uzbeko"));
        Availcurrencies.add(new Currency("UYU", "Peso uruguayo"));
        Availcurrencies.add(new Currency("CZK", "Corona checa"));
        Availcurrencies.add(new Currency("SYP", "Libra siria"));
        Availcurrencies.add(new Currency("TJS", "Somoni tayiko"));
        Availcurrencies.add(new Currency("TWD", "Nuevo dólar taiwanés"));
        Availcurrencies.add(new Currency("TZS", "Chelín tanzano"));
        Availcurrencies.add(new Currency("TOP", "Paʻanga"));
        Availcurrencies.add(new Currency("TTD", "Dólar trinitense"));
        Availcurrencies.add(new Currency("THB", "Baht tailandés"));
        Availcurrencies.add(new Currency("TRY", "Lira turca"));
        Availcurrencies.add(new Currency("TND", "Dinar tunecino"));

        Collections.sort(Availcurrencies);
    }
    public static ArrayList<Currency> getAvailCurrencies() {
        if(Availcurrencies.size()==0) {
            initAvailCurrencies();
        }
        return Availcurrencies;
    }


    @Override
    public boolean equals (Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Currency.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Currency other = (Currency) obj;
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public int compareTo(Currency o) {
        return this.name.compareTo(o.getName());
    }
}
