import java.util.Scanner;

/* Encargada de manejar la lógica de conversión de divisas. 
   Depende de la clase ConsultaConversion para obtener las tasas de cambio necesarias para realizar las conversiones. */

public class Calculos {
    private String monedaInicial;
    private String monedaFinal;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultaConversion conversion;

    /* Recibe una instancia de ConsultaConversion como parámetro y la asigna a la variable de instancia 'conversion'.
   Esto permite que cada objeto de Calculos pueda realizar consultas de tasas de cambio cuando sea necesario. */

    public Calculos(ConsultaConversion conversion) {
        this.conversion = conversion;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void almacenarValores(String monedaInicial, String monedaFinal){
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;

        System.out.println("Ingrese el monto que desea convertir");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }

    public void almacenarValoresPersonalizados(){
        String menuOtrasOpciones = """
                Currency Code       Currency Name       Country
                AED UAE Dirham                          United Arab Emirates
                AFN Afghan Afghani                      Afghanistan
                ALL	Albanian Lek	                    Albania
                AMD Armenian Dram	                    Armenia
                ANG Netherlands Antillian Guilder       Netherlands Antilles
                AOA	Angolan Kwanza	                    Angola
                ARS	Argentine Peso	                    Argentina
                AUD	Australian Dollar	                Australia
                AWG Aruban Florin	                    Aruba
                AZN Azerbaijani Manat	                Azerbaijan
                BAM Bosnia and Herzegovina Mark	        Bosnia and Herzegovina
                BBD Barbados Dollar	                    Barbados
                BDT Bangladeshi Taka	                Bangladesh
                BGN	Bulgarian Lev	                    Bulgaria
                BHD	Bahraini Dinar	                    Bahrain
                BIF	Burundian Franc	                    Burundi
                BMD	Bermudian Dollar	                Bermuda
                BND	Brunei Dollar	                    Brunei
                BOB	Bolivian Boliviano	                Bolivia
                BRL	Brazilian Real	                    Brazil
                BSD	Bahamian Dollar	                    Bahamas
                BTN	Bhutanese Ngultrum	                Bhutan
                BWP	Botswana Pula	                    Botswana
                BYN	Belarusian Ruble	                Belarus
                BZD	Belize Dollar	                    Belize
                CAD	Canadian Dollar	                    Canada
                CDF	Congolese Franc	                    Democratic Republic of the Congo
                CHF	Swiss Franc	                        Switzerland
                CLP	Chilean Peso	                    Chile
                CNY	Chinese Renminbi	                China
                COP	Colombian Peso	                    Colombia
                CRC	Costa Rican Colon	                Costa Rica
                CUP	Cuban Peso	                        Cuba
                CVE	Cape Verdean Escudo	                Cape Verde
                CZK	Czech Koruna	                    Czech Republic
                DJF	Djiboutian Franc	                Djibouti
                DKK	Danish Krone	                    Denmark
                DOP	Dominican Peso	                    Dominican Republic
                DZD	Algerian Dinar	                    Algeria
                EGP	Egyptian Pound	                    Egypt
                ERN	Eritrean Nakfa	                    Eritrea
                ETB	Ethiopian Birr	                    Ethiopia
                EUR	Euro	                            European Union
                FJD	Fiji Dollar	                        Fiji
                FKP	Falkland Islands Pound	            Falkland Islands
                FOK	Faroese Króna	                    Faroe Islands
                GBP	Pound Sterling	                    United Kingdom
                GEL	Georgian Lari	                    Georgia
                GGP	Guernsey Pound	                    Guernsey
                GHS	Ghanaian Cedi	                    Ghana
                GIP	Gibraltar Pound	                    Gibraltar
                GMD	Gambian Dalasi	                    The Gambia
                GNF	Guinean Franc	                    Guinea
                GTQ	Guatemalan Quetzal	                Guatemala
                GYD	Guyanese Dollar	                    Guyana
                HKD	Hong Kong Dollar	                Hong Kong
                HNL	Honduran Lempira	                Honduras
                HRK	Croatian Kuna	                    Croatia
                HTG	Haitian Gourde	                    Haiti
                HUF	Hungarian Forint	                Hungary
                IDR	Indonesian Rupiah	                Indonesia
                ILS	Israeli New Shekel	                Israel
                IMP	Manx Pound	                        Isle of Man
                INR	Indian Rupee	                    India
                IQD	Iraqi Dinar	                        Iraq
                IRR	Iranian Rial	                    Iran
                ISK	Icelandic Króna	                    Iceland
                JEP	Jersey Pound	                    Jersey
                JMD	Jamaican Dollar	                    Jamaica
                JOD	Jordanian Dinar	                    Jordan
                JPY	Japanese Yen	                    Japan
                KES	Kenyan Shilling	                    Kenya
                KGS	Kyrgyzstani Som	                    Kyrgyzstan
                KHR	Cambodian Riel	                    Cambodia
                KID	Kiribati Dollar	                    Kiribati
                KMF	Comorian Franc	                    Comoros
                KRW	South Korean Won	                South Korea
                KWD	Kuwaiti Dinar	                    Kuwait
                KYD	Cayman Islands Dollar	            Cayman Islands
                KZT	Kazakhstani Tenge	                Kazakhstan
                LAK	Lao Kip	                            Laos
                LBP	Lebanese Pound	                    Lebanon
                LKR	Sri Lanka Rupee	                    Sri Lanka
                LRD	Liberian Dollar	                    Liberia
                LSL	Lesotho Loti	                    Lesotho
                LYD	Libyan Dinar	                    Libya
                MAD	Moroccan Dirham	                    Morocco
                MDL	Moldovan Leu	                    Moldova
                MGA	Malagasy Ariary	                    Madagascar
                MKD	Macedonian Denar	                North Macedonia
                MMK	Burmese Kyat	                    Myanmar
                MNT	Mongolian Tögrög	                Mongolia
                MOP	Macanese Pataca	                    Macau
                MRU	Mauritanian Ouguiya	                Mauritania
                MUR	Mauritian Rupee	                    Mauritius
                MVR	Maldivian Rufiyaa	                Maldives
                MWK	Malawian Kwacha	                    Malawi
                MXN	Mexican Peso	                    Mexico
                MYR	Malaysian Ringgit	                Malaysia
                MZN	Mozambican Metical	                Mozambique
                NAD	Namibian Dollar	                    Namibia
                NGN	Nigerian Naira	                    Nigeria
                NIO	Nicaraguan Córdoba	                Nicaragua
                NOK	Norwegian Krone	                    Norway
                NPR	Nepalese Rupee	                    Nepal
                NZD	New Zealand Dollar	                New Zealand
                OMR	Omani Rial	                        Oman
                PAB	Panamanian Balboa	                Panama
                PEN	Peruvian Sol	                    Peru
                PGK	Papua New Guinean Kina	            Papua New Guinea
                PHP	Philippine Peso	                    Philippines
                PKR	Pakistani Rupee	                    Pakistan
                PLN	Polish Złoty	                    Poland
                PYG	Paraguayan Guaraní	                Paraguay
                QAR	Qatari Riyal	                    Qatar
                RON	Romanian Leu	                    Romania
                RSD	Serbian Dinar	                    Serbia
                RUB	Russian Ruble	                    Russia
                RWF	Rwandan Franc	                    Rwanda
                SAR	Saudi Riyal	Saudi                   Arabia
                SBD	Solomon Islands Dollar	            Solomon Islands
                SCR	Seychellois Rupee	                Seychelles
                SDG	Sudanese Pound	                    Sudan
                SEK	Swedish Krona	                    Sweden
                SGD	Singapore Dollar	                Singapore
                SHP	Saint Helena Pound	                Saint Helena
                SLE	Sierra Leonean Leone	            Sierra Leone
                SOS	Somali Shilling	                    Somalia
                SRD	Surinamese Dollar	                Suriname
                SSP	South Sudanese Pound	            South Sudan
                STN	São Tomé and Príncipe Dobra	        São Tomé and Príncipe
                SYP	Syrian Pound	                    Syria
                SZL	Eswatini Lilangeni	                Eswatini
                THB	Thai Baht	                        Thailand
                TJS	Tajikistani Somoni	                Tajikistan
                TMT	Turkmenistan Manat	                Turkmenistan
                TND	Tunisian Dinar	                    Tunisia
                TOP	Tongan Paʻanga	                    Tonga
                TRY	Turkish Lira	                    Turkey
                TTD	Trinidad and Tobago Dollar	        Trinidad and Tobago
                TVD	Tuvaluan Dollar	                    Tuvalu
                TWD	New Taiwan Dollar	                Taiwan
                TZS	Tanzanian Shilling	                Tanzania
                UAH	Ukrainian Hryvnia	                Ukraine
                UGX	Ugandan Shilling	                Uganda
                USD	United States Dollar	            United States
                UYU	Uruguayan Peso	                    Uruguay
                UZS	Uzbekistani So'm	                Uzbekistan
                VES	Venezuelan Bolívar Soberano	        Venezuela
                VND	Vietnamese Đồng	                    Vietnam
                VUV	Vanuatu Vatu	                    Vanuatu
                WST	Samoan Tālā	                        Samoa
                XAF	Central African CFA Franc	        CEMAC
                XCD	East Caribbean Dollar	            Organisation of Eastern Caribbean States
                XDR	Special Drawing Rights	            International Monetary Fund
                XOF	West African CFA franc	            CFA
                XPF	CFP Franc	                        Collectivités d'Outre-Mer
                YER	Yemeni Rial                     	Yemen
                ZAR	South African Rand	                South Africa
                ZMW	Zambian Kwacha	                    Zambia
                ZWL	Zimbabwean Dollar	                Zimbabwe
                """;
        System.out.println(menuOtrasOpciones);
        System.out.println("Ingrese las 3 letras de la moneda origen");
        this.monedaInicial = lectura.next();
        System.out.println("Ingrese las 3 letras de la moneda final");
        this.monedaFinal = lectura.next();

        boolean entradaValida = false;
        do {
            System.out.println("Ingrese el monto que desea convertir");
            if (lectura.hasNextDouble()) {
                this.cantidad = lectura.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Error. El valor debe ser numerico.");
                lectura.next(); // Limpiar el buffer de entrada
            }
        } while (!entradaValida);
    }

    public String obtenerMensajeRespuesta() {
        String mensaje = getMonedaInicial().toUpperCase() + " " + getCantidad() + " equivale a: " + getMonedaFinal().toUpperCase() + " " + conversion.buscaConversion(getMonedaInicial(), getMonedaFinal(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}
