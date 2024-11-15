package com.uhbooba.financeservice.util;

import com.uhbooba.financeservice.dto.UserHeaderInfo;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.http.HttpHeaders;

public class CommonUtil {

    public static UserHeaderInfo getUserHeaderInfo(HttpHeaders headers) {
        String userServiceId = headers.get("X-UserId")
                                      .get(0);

        String name = headers.get("X-Name")
                             .get(0);

        name = URLDecoder.decode(name, StandardCharsets.UTF_8);

        Integer userId = Integer.parseInt(userServiceId);

        return UserHeaderInfo.builder()
                             .userId(userId)
                             .name(name)
                             .build();
    }

    public static String formatWithCommas(long amount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(amount);
    }
}
