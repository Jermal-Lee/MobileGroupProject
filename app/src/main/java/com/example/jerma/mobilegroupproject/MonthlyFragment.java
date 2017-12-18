package com.example.jerma.mobilegroupproject;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MonthlyFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public MonthlyFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MonthlyFragment.
//     */
    // TODO: Rename and change types and number of parameters
//    public static MonthlyFragment newInstance(String param1, String param2) {
//        MonthlyFragment fragment = new MonthlyFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_monthly, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.monthly_recyclerView);
        recyclerView.setHasFixedSize(true);

        MonthlyAdapter monthlyAdapter = new MonthlyAdapter(new String[]{"December","November","October","September","August","July","June","May","April","March","February","January"},
                new String[]{"45","65","53","53","53","53","53","53","53","53","53","53"},
                new String[]{"32","26","26","26","26","26","26","26","26","26","26","26"},
                new String[]{"102","99","99","99","99","99","99","99","99","99","99","99"});

        recyclerView.setAdapter(monthlyAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return rootView;

    }

    static class MonthlyAdapter extends RecyclerView.Adapter<MonthlyAdapter.MyViewHolder>{

        private String [] month, price, qty, trip;

        static class MyViewHolder extends RecyclerView.ViewHolder {

            public CardView mCardView;
            public TextView monthTextView, priceTextView, qtyTextView, tripTextView;

            public MyViewHolder(View itemView) {
                super(itemView);
                mCardView = itemView.findViewById(R.id.month_cardView);
                monthTextView = itemView.findViewById(R.id.month_textView);
                priceTextView = itemView.findViewById(R.id.price_textView);
                qtyTextView = itemView.findViewById(R.id.qty_textView);
                tripTextView = itemView.findViewById(R.id.trip_textView);
            }
        }

        MonthlyAdapter(String[] mMonth, String[] mPrice, String[] mQty, String[] mTrip){
            this.month = mMonth;
            this.price = mPrice;
            this.qty = mQty;
            this.trip = mTrip;
        }

        @Override
        public MonthlyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.monthly_layout, parent, false);

            return new MyViewHolder(view);
        }


        @Override
        public void onBindViewHolder(MonthlyAdapter.MyViewHolder holder, int position) {

            holder.monthTextView.setText(month[position]);
            holder.priceTextView.setText("$"+price[position]);
            holder.qtyTextView.setText(qty[position]+" Litres of gas purchased");
            holder.tripTextView.setText("Travelled "+trip[position]+" Kms");

        }

        @Override
        public int getItemCount() {
            return month.length;
        }
    }



    // TODO: Rename method, update argument and hook method into UI event
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

//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
