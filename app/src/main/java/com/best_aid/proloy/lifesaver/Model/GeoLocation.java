package com.best_aid.proloy.lifesaver.Model;

public class GeoLocation {

/*    public static void getAdress(final double locationAdress , final Context context , final Handler handler)
    {
        Thread  thread = new Thread(){
            @Override
            public void run() {
                Geocoder  geocoder = new Geocoder(context , Locale.getDefault());
                String result = null ;
                try {
                    List adressList = geocoder.getFromLocation(locationAdress,1,1);
                    if(adressList != null && adressList.size()>0)
                    {
                        Address address = (Address)adressList.get(0);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(address.getLatitude()).append("\n");
                        stringBuilder.append(address.getLongitude()).append("\n");
                        result = stringBuilder.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                }
            }
        }
    }*/
}
