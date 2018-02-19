package com.khsm.app.presentation.ui.screens.meetings;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khsm.app.R;

import java.util.List;

public class MeetingListAdapter extends RecyclerView.Adapter<MeetingListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Meeting> meetings;

    MeetingListAdapter(Context context, List<Meeting> meetings) {
        this.meetings = meetings;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MeetingListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.meeting_list_item, parent, false);
        return new MeetingListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingListAdapter.ViewHolder holder, int position) {
        Meeting meeting = meetings.get(position);
        holder.dateMeeting.setText((CharSequence) meeting.getDate());

    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView dateMeeting;
        ViewHolder(View view){
            super(view);
            dateMeeting = view.findViewById(R.id.dateMeeting);
        }
    }
}