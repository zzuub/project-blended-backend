package com.gdsc.blended.post.heart.controller;

import com.gdsc.blended.post.heart.service.HeartService;
import com.gdsc.blended.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post/{postId}/heart")
public class HeartController {

    private final HeartService heartService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> likeBoard(@PathVariable Long postId, @AuthenticationPrincipal User user) {
        heartService.likeBoard(postId, user.getUserId());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}