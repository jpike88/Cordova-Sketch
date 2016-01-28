package com.formpigeon.sketch;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.util.Base64;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.formpigeon.sketch.ImageCaption;
import java.util.ArrayList;
import android.widget.TextView;

/**
 * Created by joshua on 27/01/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private ArrayList imageArray = new ArrayList();
    private ArrayList titleArray = new ArrayList();

    public ImageAdapter(Context c) {
        mContext = c;
        loadStamps();
    }

    public int getCount() {
        return imageArray.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public void loadStamps(){


         String img = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAu1JREFUeNrsne1xo0AMhjdXgdPBlkAJdBBSwdFBXII7SAkugevAJVAC6YDrgHAzeHznObCB/ZB2n2dG/5yxWaF3haQNxgAAAAAAAAAA+KBgCWTRjmZZBjnRMYx2Yilk8Dk5pGMpZNBNDhnYS+JT/eWMYYoWiMj5ziHIVkQOo/V3DkG2IlL/xxnDFDUQgWbGIT1LEx4744yrVRov6ofy7GqJN+7ZsLQPIgTZCkjxwBlqZUurZP10/DnYSfdkhAzTswp43syHFVYjWX558/x5WMFcqSQZ2dIWIdXGxa25l/3QbIiOYXpmAcfYjc64mkWywpZKfP89rCyVIFsCSyXqZUuLZLkqgXxwb4cvlSwZ/fYIpZJHJrrfrkGyXJc+qABHKJUkKVsnxwuBORjoKx1uqNittVzulY0zC+nEGuOw8lx50POcoqL2VeC7sMCr7BKiQnBkoZ+yU+j6UsuizxYyozyAHszt9BJ2S2ejt4xLNvz96ayPaGkM6aw46oyixVs66yM9Tn3DD5LOUg8TmM76SI9TqYdFS2d9bPja62Ei0lkf3T9tG764dNZHtGiphzUmo+MMR8HRoiadzaEepjKddc1FkERFRcrUieV3yJItSZJlc48QaXNS2U/JS3uKz3rctDIy094iV8mSekI223FTqQ+GHXIlz8rcJEv6gf4osvUS6WKvU+2S+T3aay4RoiHXP8T4nbEc4lquvkZ7H+1XZrLq7M7z2clzXdZPvh/iai64W8iE/tSjXFWQ69Qd0ppw/W0X0dKk7Axr9nfyqg3f2SJb7uVqb3/7tOO7j8jVvqiYY2vLOMn/k1IYOVMfW6LFpuaQz0hRMUdp1vVikpOtzsibhVpz4KjLTa5CRMXeaClykauLgNTymfnjZF6n1C9EhTRtXpo/TkK2KqNvQnDpeJ76qZSzgqhYEy3qX6fUG91zs/fT+qrfS1IpjIqlsk+vXbYak9Y0uZ2uR20FuDZpkup1AQAAAAAAAMA/fAswAKsRyVczAT7MAAAAAElFTkSuQmCC";
         String img2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA4xJREFUeNrsnOutnDAQhScdUIJLoARKoATSwXYQUsGWQAlbAumAdEA6IB0QrkSivcTYxvg19vkk/1wJP+Z4fDxeIgAAAAAAAAAAAAAf1BiCtJi2JjAM6UTHurUeQ5EGz31CZgxFGsz7hKzYS+LTvk3GukcLiMhwmBDIVkSqrS2HCYFsRaSTTMa6Rw2IwOtkQhYMTXjEyWT8bS2GKCwPzYRAtgIzaSYEshWQWjIBT8hWPGSDXx1O7Ou+6YMAnA382UQBj7QKaZJJWYch88ug2bwhW5GtkmN620O24loltcGB8YGhC2OVzIZnlAlDF8Yq6S+c4gWG0L9VIi5MHmTLs1Wik6ERshXWKtGdLzrIVnirRJciy/wu4NEqcZWVAUdWiYtzC3BslUC2ErNKrk4oW9nqSX0jF6s1DiQvhWYVqY1kQ43ZbFf3klAfFotF9Z9sDJxXVULf/yKHznObwEoTN749dlR0Jh/6xcLgGxQh93Nr37f229O+9uPGbxtP3/Sx4r8p0umPb/66tV+hjb53nW+oDHR7bB/aX5pS+ZjEstAp1gG0OvGZon9YxIX4pASujBvFhr9QPncRD00/k5Lqis6r0Z2nfBH6NnLtW6dZRdzKO1tNfzoOnRAcdPbmgXgkhhdeSWYi3NJZH1kJp85xXUTZhT+LdLaUDZJVOptzCsk6nQ25KucAWp1FOhtSt30PyDOndNY1MtnwLRXiRKIAxXtkgyr5E9mK9QwNVfKGWh4qs5HJVvFV8ke5Cv0PDCOh3PRT6hn7sX9HKDf9x50yUZeHQ5Sb7twtEz0e8mz9JlTJO5Ir2S2ljSMr+5amdLmaLaPCla3vKlpZcke3dZUuttGSwn4WDdvMpiG74u/eUraK+Xunq5uoLirmffBUVS8mpuFcomxVF1ewLiqOmZXusumRqGsQDVP/yCQqGoUlMlpES5F/72TisF6NCtXkX60RK+rvnQSpzTxdVNgU2glSFy8cr2n7kmRLJVe6cqG799u94UTrFk3WcjVeHKy71IbRUsTF1dlfu04Uvuqj1yQLLyrg4sr0dB2qKPvqITM72TLtfOi6LNOFMucuVyk9VTCNlroUuRoTSC1N3uNnc3HF6bmbytbPQrZa4lchqHqex94BHojvI1BZtLB3gBfiXTd7rJBnfXHVUj5Po9+NSray9aK8qsnF3h+2DnBHeZJrvwAAAAAAAAAAAPCJPwIMAHVyouNVz0EzAAAAAElFTkSuQmCC";

        String tit1 = "derp";
        String tit2 = "flirp";

        byte[] decodedString = Base64.decode(img.substring(img.indexOf(",") + 1), Base64.DEFAULT);
        byte[] decodedString2 = Base64.decode(img2.substring(img2.indexOf(",") + 1), Base64.DEFAULT);

        Bitmap image = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        Bitmap image2 = BitmapFactory.decodeByteArray(decodedString2, 0, decodedString2.length);


        imageArray.add(image);
        imageArray.add(image2);

        titleArray.add(tit1);
        titleArray.add(tit2);


    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageCaption imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageCaption(mContext);
            Bitmap b = (Bitmap) imageArray.get(position);
            imageView.setImageBitmap(b);
            imageView.setMinimumHeight(b.getHeight() + 200);
            imageView.setCaption((String) titleArray.get(position));


        } else {
            imageView = (ImageCaption) convertView;
        }

        System.out.println("wattt");

        return imageView;
    }


}