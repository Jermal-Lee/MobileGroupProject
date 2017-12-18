package com.example.jerma.mobilegroupproject;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class HistoryFragment extends android.support.v4.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public HistoryFragment() {
        // Required empty public constructor
    }

//    public static HistoryFragment newInstance(String param1, String param2) {
//        HistoryFragment fragment = new HistoryFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_history, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.history_recyclerView);
        recyclerView.setHasFixedSize(true);

        HistoryAdapter historyAdapter = new HistoryAdapter(new String[]{"15 December 2017","10 December 2017","5 December 2017","1 December 2017","25 November 2017","15 November 2017","15 December 2017","10 December 2017","5 December 2017","1 December 2017","25 November 2017","15 November 2017"},
                new String[]{"$23","$20","$26","$21","$32","$13","$23","$20","$26","$21","$32","$13"},
                new String[]{"20 Litres","18 Litres","24 Litres","19 Litres","30 Litres","10 Litres","20 Litres","18 Litres","24 Litres","19 Litres","30 Litres","10 Litres"},
                new String[]{"210 Kms", "190 Kms", "223 Kms", "186 Kms", "257 Kms", "94 Kms","210 Kms", "190 Kms", "223 Kms", "186 Kms", "257 Kms", "94 Kms"});

        recyclerView.setAdapter(historyAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return rootView;

    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    static class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{

        private String[] date, price, liter, trip;

        static class MyViewHolder extends RecyclerView.ViewHolder {

            public CardView mCardView;
            public ImageView gasImage;
            public TextView dateTextView , priceTextView , kmTextView , qtyTextView  ;

            public MyViewHolder(View itemView) {
                super(itemView);

                mCardView = itemView.findViewById(R.id.history_cardView);
                gasImage = itemView.findViewById(R.id.gas_imageView);
                dateTextView = itemView.findViewById(R.id.date_textView);
                priceTextView = itemView.findViewById(R.id.history_price_textView);
                kmTextView = itemView.findViewById(R.id.history_trip_textView);
                qtyTextView = itemView.findViewById(R.id.history_qty_textView);
            }
        }

        HistoryAdapter(String[] mDate, String[] mPrice, String[] mLiter, String[] mTrip){
            this.date = mDate;
            this.price = mPrice;
            this.liter = mLiter;
            this.trip = mTrip;
        }

        @Override
        public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_layout, parent, false); // Create a new View

            MyViewHolder myViewHolder = new MyViewHolder(view);  // Sets the Views size, padding and other layout parameters
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(HistoryAdapter.MyViewHolder holder, int position) {

            holder.dateTextView.setText(date[position]);
            holder.priceTextView.setText(price[position]);
            holder.qtyTextView.setText(liter[position]);
            holder.kmTextView.setText(trip[position]);

        }

        @Override
        public int getItemCount() {

            return date.length;

        }



    }

}