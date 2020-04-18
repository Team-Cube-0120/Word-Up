package e.gatech.wordup.demo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class create_event extends AppCompatActivity {

    EditText startDate;
    EditText endDate;
    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_activity);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };


        startDate = findViewById(R.id.starDate);
        endDate = findViewById(R.id.endDate);


            startDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(create_event.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            month++;

                            String newMonth = month + "", newDay = dayOfMonth + "";

                            if (month < 10) {
                                newMonth = "0" + month;
                            }
                            if (dayOfMonth < 10) {
                                newDay = "0" + dayOfMonth;
                            }
                            String finalDate = getMonth(Integer.parseInt(newMonth)) + " " + newDay + ", " + year;
                            startDate.setText(finalDate);
                        }
                    }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));

                    datePickerDialog.show();
                }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(create_event.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month++;

                        String newMonth = month + "", newDay = dayOfMonth + "";

                        if (month < 10) {
                            newMonth = "0" + month;
                        }
                        if (dayOfMonth < 10) {
                            newDay = "0" + dayOfMonth;
                        }
                        String finalDate = getMonth(Integer.parseInt(newMonth)) + " " + newDay + ", " + year;
                        endDate.setText(finalDate);
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });

        final EditText startTime = findViewById(R.id.startTime);
        final EditText endTime = findViewById(R.id.endTime);
        startTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY) - 4;
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(create_event.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        int hour = selectedHour;
                        int minutes = selectedMinute;
                        String timeSet = "";
                        if (hour > 12) {
                            hour -= 12;
                            timeSet = "PM";
                        } else if (hour == 0) {
                            hour += 12;
                            timeSet = "AM";
                        } else if (hour == 12){
                            timeSet = "PM";
                        }else{
                            timeSet = "AM";
                        }

                        String min = "";
                        if (minutes < 10)
                            min = "0" + minutes ;
                        else
                            min = String.valueOf(minutes);

                        String newTime = new StringBuilder().append(hour).append(':')
                                .append(min ).append(" ").append(timeSet).toString();
                            startTime.setText(newTime);
                    }
                }, hour, minute, true);
                mTimePicker.show();

            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY) - 4;
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(create_event.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        int hour = selectedHour;
                        int minutes = selectedMinute;
                        String timeSet = "";
                        if (hour > 12) {
                            hour -= 12;
                            timeSet = "PM";
                        } else if (hour == 0) {
                            hour += 12;
                            timeSet = "AM";
                        } else if (hour == 12){
                            timeSet = "PM";
                        }else{
                            timeSet = "AM";
                        }

                        String min = "";
                        if (minutes < 10)
                            min = "0" + minutes ;
                        else
                            min = String.valueOf(minutes);

                        String newTime = new StringBuilder().append(hour).append(':')
                                .append(min ).append(" ").append(timeSet).toString();
                        endTime.setText(newTime);
                    }
                }, hour, minute, true);
                mTimePicker.show();

            }
        });

        Spinner dropdown = (Spinner)findViewById(R.id.location);

        String[] items = new String[]{"East Hampton", "West Hampton", "Downtown Hampton", "Olde Hampton", "Location"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView) v).setGravity(Gravity.CENTER);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }

        };
        adapter.addAll(items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setSelection(adapter.getCount());

        Spinner dropdown2 = findViewById(R.id.choiceType);
        String[] types = new String[]{"Party", "Volunteering", "Gathering", "Sports", "Education", "Other", "Event Type"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView) v).setGravity(Gravity.CENTER);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }

        };
        adapter2.addAll(types);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(adapter2);
        dropdown2.setSelection(adapter2.getCount());


        Button post = findViewById(R.id.postButton);

        final EditText eventName = findViewById(R.id.eventName);

        final EditText info = findViewById(R.id.information);

        final EditText rsvp = findViewById(R.id.rsvp);

        final EditText coHost = findViewById(R.id.coHosts);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (startTime.length() > 0 && endTime.length() > 0 && startDate.length() > 0 && endDate.length() > 0 && eventName.length() > 0 && info.length() > 0 && coHost.length() >0 ) {
                    Intent intent = new Intent(create_event.this, main_Actvity_two.class);
                    startActivity(intent);
                } else {
                    Toast toast =  Toast.makeText(getApplicationContext(),"All required information has not been filled out. Try again!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }


            }
        });

    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        startDate.setText(sdf.format(myCalendar.getTime()));
    }
    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }


}
