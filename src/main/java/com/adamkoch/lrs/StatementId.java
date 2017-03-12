package com.adamkoch.lrs;

import java.util.UUID;

/**
 * Created by aakoch on 2017-03-11
 */
public class StatementId {

    private final UUID id;

    StatementId(UUID id) {
        this.id = id;
    }

    public static StatementId of(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid statement ID \"" + id + "\". Must be a RFC 4122 UUID. See https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#stmtid", e);
        }
        return new StatementId(uuid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatementId that = (StatementId) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
