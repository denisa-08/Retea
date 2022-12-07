package domain.validators;

import domain.Friendship;

import java.util.Map;

public class FriendshipValidator implements Validator<Friendship> {
    @Override
    public void validate(Friendship entity) throws ValidationException {
        String errors = "";
        if(entity.getId() == null)
            errors += "Id null!";

        if(!errors.equals(""))
            throw new ValidationException(errors);
    }
}
