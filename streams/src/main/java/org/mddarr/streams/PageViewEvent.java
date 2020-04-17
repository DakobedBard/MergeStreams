package org.mddarr.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class PageViewEvent {
    private String userId, page;
    private long duration;

}
