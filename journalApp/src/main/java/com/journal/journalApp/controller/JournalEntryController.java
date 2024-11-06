package com.journal.journalApp.controller;

import com.journal.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

private Map<Long, JournalEntry> journalEntryMap=new HashMap<>();
@GetMapping
public List<JournalEntry> getAll(){
    return new ArrayList<>(journalEntryMap.values());
}

@PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
    journalEntryMap.put(myEntry.getId(), myEntry);
    return true;
}
@GetMapping("id/{myId}")
   public JournalEntry getJournalEntryById(@PathVariable Long myId){
    return journalEntryMap.get(myId);
}
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntryMap.remove(myId);
    }
@PutMapping("id/{id}")
    public JournalEntry updateJournalEntity(@PathVariable Long id,@RequestBody JournalEntry myEntry ){
   return journalEntryMap.put(id,myEntry);
    }
}
